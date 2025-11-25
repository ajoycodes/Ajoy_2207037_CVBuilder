package com.example.demo;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CvBuilderController {

    @FXML private TextField fn, em, ph, ad, ns;
    @FXML private TextArea sm, ed, ex;
    @FXML private ListView<String> lv;
    @FXML private ListView<CvRecord> savedList;
    @FXML private TextField search;
    @FXML private WebView pv;
    @FXML private Label st;

    private final ObservableList<String> sk = FXCollections.observableArrayList();
    private final ObservableList<CvRecord> allRecords = FXCollections.observableArrayList();
    private FilteredList<CvRecord> filtered;
    private final Gson gson = new Gson();

    @FXML
    public void initialize() {
        lv.setItems(sk);

        filtered = new FilteredList<>(allRecords, r -> true);
        savedList.setItems(filtered);

        pv.getEngine().loadContent("<h3 style='text-align:center;padding:40px;font-family:Inter;color:#555'>Preview will appear here</h3>");

        savedList.getSelectionModel().selectedItemProperty().addListener((obs, old, rec) -> {
            if (rec != null) showCv(rec.getCv());
        });

        if (search != null) {
            search.textProperty().addListener((obs, o, n) -> {
                String t = n == null ? "" : n.toLowerCase();
                filtered.setPredicate(rec -> {
                    if (t.isEmpty()) return true;
                    String name = rec.getCv().getFn();
                    String email = rec.getCv().getEm();
                    name = name == null ? "" : name.toLowerCase();
                    email = email == null ? "" : email.toLowerCase();
                    return name.contains(t) || email.contains(t);
                });
            });
        }

        loadFromDbAsync();
    }

    @FXML
    private void add() {
        String v = ns.getText();
        if (!v.isBlank()) sk.add(v.trim());
        ns.clear();
        upd();
    }

    @FXML
    private void rm() {
        String v = lv.getSelectionModel().getSelectedItem();
        if (v != null) sk.remove(v);
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
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File", "*.html"));
        File f = fc.showSaveDialog(null);
        if (f == null) return;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(c.html());
            st.setText("Saved HTML: " + f.getAbsolutePath());
        } catch (Exception ex) {
            st.setText("Error saving HTML");
        }
    }

    @FXML
    private void newCv() {
        fn.clear();
        em.clear();
        ph.clear();
        ad.clear();
        sm.clear();
        ed.clear();
        ex.clear();
        sk.clear();
        lv.getSelectionModel().clearSelection();
        savedList.getSelectionModel().clearSelection();
        st.setText("New CV");
        upd();
    }

    }
}