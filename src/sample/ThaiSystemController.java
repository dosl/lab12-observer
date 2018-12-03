package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThaiSystemController implements Observer {
    @FXML
    Label slungLabel, bathLabel, tamleunglLabel,changLabel,harbLabel;
    private ThaiSystem thaiSystem;
    public void initialize(){
        thaiSystem = new ThaiSystem();
    }


    @Override
    public void update(String unit, double value) {
        if (unit.equals("kg")){
            thaiSystem.setFromMetricSystem(value);
        }else if (unit.equals("lb")){
            thaiSystem.setFromEnglishSystem(value);
        }else if (unit.equals("tamleung")){
            thaiSystem.setTamleung(value);
        }
        slungLabel.setText(thaiSystem.toSlung()+"");
        bathLabel.setText(thaiSystem.toBath()+"");
        tamleunglLabel.setText(thaiSystem.getTamleung()+"");
        changLabel.setText(thaiSystem.toChang()+"");
        harbLabel.setText(thaiSystem.toHarb()+"");
    }
}
