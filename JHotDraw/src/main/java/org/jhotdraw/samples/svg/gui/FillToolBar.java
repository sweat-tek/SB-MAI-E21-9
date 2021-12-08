/*
 * @(#)FillToolBar.java  1.2  2008-05-23
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.action.SelectionComponentRepainter;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * FillToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.2 2008-05-23 Hide the toolbar if nothing is selected, and no
 * creation tool is active.
 * <br>1.1 2008-03-26 Don't draw button borders.
 * <br>1.0 May 1, 2007 Created.
 */
public class FillToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;

    /**
     * Creates new instance.
     */
    public FillToolBar() {
        ResourceBundleUtil labels = getResourceBundleUtil();
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        DrawingEditor oldValue = getEditor();
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.FILL_PALETTE)
    /*protected*/public JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        switch (state) {
            case 1: {
                p = initClosedPanelState();
                break;
            }
            case 2: {
                p = initOpenPanelState();
                break;
            }
        }
        return p;
    }

    //@org.jetbrains.annotations.NotNull
    // Refactor: Extract Method
    private JPanel initClosedPanelState() {
        JPanel p = createJPanel();
        ResourceBundleUtil labels = getResourceBundleUtil();
        GridBagLayout layout = new GridBagLayout();
        p.setLayout(layout);
        createFillColor(p, labels);
        createOpacitySlider(p, labels);
        return p;
    }

    //@org.jetbrains.annotations.NotNull
    // Refactor: Extract Method
    private JPanel initOpenPanelState() {
        JPanel p = createJPanel();
        p.removeAll();

        JPanel p1 = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);

        ResourceBundleUtil labels = getResourceBundleUtil();

        GridBagLayout layout = new GridBagLayout();
        p.setLayout(layout);

        this.createColorField(p1, labels); // fill color field
        this.createColorButton(p1, labels); // fill color button

        this.createOpacityField(p2, labels);
        this.createOpacitySlider(p2, labels);

        this.createHorizontalStrip(p, p1, 0, 0.f);
        this.createHorizontalStrip(p, p2, 1, 0.f);
        this.createHorizontalStrip(p, p3, 2, 1.f);

        return p;
    }

    //@org.jetbrains.annotations.NotNull
    // Refactor: Extract Method
    private JPanel createJPanel() {
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(5, 5, 5, 8));
        return p;
    }

    // Refactor: Extract Method
    private void createOpacityField(JPanel p, ResourceBundleUtil labels) {
        GridBagConstraints gbc;

        JAttributeTextField<Double> opacityField = new JAttributeTextField<Double>();
        opacityField.setColumns(3);
        opacityField.setToolTipText(labels.getString("attribute.fillOpacity.toolTipText"));
        opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
        opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
        opacityField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1d, 100d));
        opacityField.setHorizontalAlignment(JTextField.LEFT);

        new FigureAttributeEditorHandler<Double>(FILL_OPACITY, opacityField, editor);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        p.add(opacityField, gbc);
    }

    // Refactor: Extract Method
    private void createOpacitySlider(JPanel p, ResourceBundleUtil labels) {
        GridBagConstraints gbc;

        // Opacity slider
        JPopupButton opacityPopupButton = new JPopupButton();
        JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
        opacityPopupButton.add(opacitySlider);

        labels.configureToolBarButton(opacityPopupButton, "attribute.fillOpacity");

        opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
        opacityPopupButton.setIcon(
                new SelectionOpacityIcon(editor, FILL_OPACITY, FILL_COLOR, null, getClass().getResource(labels.getString("attribute.fillOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
        opacityPopupButton.setPopupAnchor(SOUTH_EAST);

        new SelectionComponentRepainter(editor, opacityPopupButton);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 1f;
        gbc.insets = new Insets(3, 0, 0, 0);

        p.add(opacityPopupButton, gbc);

        opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
        opacitySlider.setScaleFactor(100d);

        new FigureAttributeEditorHandler<Double>(FILL_OPACITY, opacitySlider, editor);
    }

    // Refactor: Extract Method
    private void createHorizontalStrip(JPanel p, JPanel pX, int gridy, float weighty) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = gridy;
        gbc.weighty = weighty;

        p.add(pX, gbc);
    }

    // Refactor: Extract Method
    private void createFillColor(JPanel p, ResourceBundleUtil labels) {
        GridBagConstraints gbc;
        AbstractButton btn;

        // Fill color
        Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
        FILL_GRADIENT.set(defaultAttributes, null);
        btn = ButtonFactory.createSelectionColorButton(editor,
                FILL_COLOR, ButtonFactory.HSV_COLORS, ButtonFactory.HSV_COLORS_COLUMN_COUNT,
                "attribute.fillColor", labels, defaultAttributes, new Rectangle(3, 3, 10, 10));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        ((JPopupButton) btn).setAction(null, null);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(btn, gbc);
    }

    // Refactor: Extract Method
    private ResourceBundleUtil getResourceBundleUtil() {
        return ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
    }

    // Refactor: Extract Method
    private void createColorField(JPanel p, ResourceBundleUtil labels) {
        GridBagConstraints gbc;

        Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
        FILL_GRADIENT.set(defaultAttributes, null);

        JAttributeTextField<Color> colorField = new JAttributeTextField<Color>();
        colorField.setColumns(7);
        colorField.setToolTipText(labels.getString("attribute.fillColor.toolTipText"));
        colorField.putClientProperty("Palette.Component.segmentPosition", "first");
        colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
        colorField.setFormatterFactory(ColorFormatter.createFormatterFactory());
        colorField.setHorizontalAlignment(JTextField.LEFT);

        new FigureAttributeEditorHandler<Color>(FILL_COLOR, defaultAttributes, colorField, editor, true);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        p.add(colorField, gbc);
    }

    private void createColorButton(JPanel p, ResourceBundleUtil labels) {
        GridBagConstraints gbc;
        AbstractButton btn;

        Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
        FILL_GRADIENT.set(defaultAttributes, null);

        btn = ButtonFactory.createSelectionColorButton(editor,
                FILL_COLOR, ButtonFactory.HSV_COLORS, ButtonFactory.HSV_COLORS_COLUMN_COUNT,
                "attribute.fillColor", labels, defaultAttributes, new Rectangle(3, 3, 10, 10));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        ((JPopupButton) btn).setAction(null, null);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        p.add(btn, gbc);
    }

    @Override
    protected String getID() {
        return "fill";
    }

    @Override
    protected int getDefaultDisclosureState() {
        return 1;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
