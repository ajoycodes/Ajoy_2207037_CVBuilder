package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.*;

public class CvBuilderController {

    @FXML private TextField fn, em, ph, ad, ns;
    @FXML private TextArea sm, ed, ex;
    @FXML private ListView<String> lv;
    @FXML private WebView pv;
    @FXML private Label st;

    private final ObservableList<String> sk = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        lv.setItems(sk);
        pv.getEngine().loadContent("<h3 style='text-align:center;font-family:Inter;padding:40px;color:#444'>Preview will appear here</h3>");
    }

    @FXML
    private void add() {
        String v = ns.getText();
        if(!v.isBlank()) sk.add(v.trim());
        ns.clear();
        upd();
    }

    @FXML
    private void rm() {
        String v = lv.getSelectionModel().getSelectedItem();
        if(v!=null) sk.remove(v);
        upd();
    }

    @FXML
    private void gen() {
        upd();
    }

    private void upd() {
        pv.getEngine().loadContent(cv().html());
    }

    @FXML
    private void save() {
        upd();
        CurriculumVitae c = cv();

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File","*.html"));
        File f = fc.showSaveDialog(null);
        if(f==null) return;

        try(BufferedWriter bw=new BufferedWriter(new FileWriter(f))) {
            bw.write(c.html());
            st.setText("Saved: " + f.getAbsolutePath());
        } catch(Exception e){
            st.setText("Error saving");
        }
    }

    private CurriculumVitae cv(){
        CurriculumVitae c=new CurriculumVitae();
        c.setFn(fn.getText());
        c.setEm(em.getText());
        c.setPh(ph.getText());
        c.setAd(ad.getText());
        c.setSm(sm.getText());
        c.setEd(ed.getText());
        c.setEx(ex.getText());
        sk.forEach(c::addSk);
        return c;
    }
}