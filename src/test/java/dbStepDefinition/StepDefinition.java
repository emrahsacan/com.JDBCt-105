package dbStepDefinition;

import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils1.*;

public class StepDefinition {

    List<Object> staffTablosundakiIDler = new ArrayList<>();

    @Given("Database baglantisi kurulur")
    public void database_baglantisi_kurulur() {
        createConnection();

    }
    @Given("Stafs tablosundaki {string} leri listeler")
    public void stafs_tablosundaki_leri_listeler(String Id) {
        staffTablosundakiIDler = getColumnData("SELECT * FROM u480337000_tlb_training.staff",Id);
        System.out.println(staffTablosundakiIDler);
    }
    @Given("verilen {string} dogrulanir.")
    public void verilen_dogrulanir(String id) {
        assertTrue(staffTablosundakiIDler.toString().contains(id));

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {
        closeConnection();

    }
}
