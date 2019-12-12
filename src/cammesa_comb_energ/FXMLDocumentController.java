/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cammesa_comb_energ;

import cammesa_comb_energ.IO.conectarAccess;
import estruct.energia;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author hgomez
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ComboBox<String> cb_grupo;
    @FXML
    private Button bt_graf;
//    @FXML
    //private LineChart<Number, Number> plot_generacion;
    
    @FXML
    final NumberAxis xAxis = new NumberAxis();
    @FXML
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart<Double,Double> plot_generacion;
    @FXML
    private Label lb_consol;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        bt_graf.setDisable(true);
        lb_consol.setText("Haciendo consulta a Access, wait");
        conectarAccess cA = new conectarAccess();
        List data = cA.getData(cb_grupo.getValue().toString());
        lb_consol.setText("Graficando");
        cargarGraf(data,cb_grupo.getValue().toString());
        lb_consol.setText("Listo");
        bt_graf.setDisable(false);
    }
    
    public void cargarGraf(List data,String titulo){
        plot_generacion.setTitle(titulo);
//        XYChart.Series<Double,Double> serie_en = new XYChart.Series<>();
//        serie_en.setName("Energia Neta");
//        XYChart.Series<Double,Double> serie_eb = new XYChart.Series();
//        serie_eb.setName("Energia Bruta");
        Iterator it = data.iterator();
        ObservableList<XYChart.Series<Double, Double>> answer = FXCollections.observableArrayList();
        LineChart.Series<Double, Double> serie_en = new Series<Double, Double>();
        LineChart.Series<Double, Double> serie_eb = new Series<Double, Double>();
        serie_en.setName("Energia Neta");
        serie_eb.setName("Energia Bruta");
//        
        while(it.hasNext()){
            energia aux = (energia)it.next();
            serie_en.getData().add(new XYChart.Data(aux.getT(), aux.getEn()));
            serie_eb.getData().add(new XYChart.Data(aux.getT(), aux.getEb()));
            System.out.println(aux.getT()+"\t"+ aux.getEn()+"\t"+aux.getEb());
        }
        answer.addAll(serie_en,serie_eb);
        plot_generacion.setData(answer);
        plot_generacion = new LineChart(xAxis,yAxis);
        
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        cb_grupo.getItems().addAll("3ARRDI01",
"BICEEO",
"BLOPTG01",
"BOLIDI01",
"9JULDI01",
"ABRODI01",
"ACAJTG01",
"ACAJTG02",
"ACAJTG03",
"ACAJTG04",
"ACAJTG05",
"ACAJTG06",
"ACAJTV07",
"ACHIEO",
"ADTOHI",
"AESPTG01",
"AESPTG02",
"AESPTG04",
"AESPTV01",
"ALEMDI01",
"ALICHI",
"ALOMDI01",
"ALU1EO",
"ALUAEO",
"ALUATG05",
"ALUATG06",
"ALUATG07",
"ALUATG08",
"ALUATV01",
"ALUMDI01",
"AMEGHI",
"ANATDI01",
"ANATDI02",
"ANCHDI01",
"ANCHDI02",
"ANCHDI03",
"ANCHDI04",
"APARTV01",
"ARA2EO",
"ARAUEO",
"ARGETG01",
"ARISDI01",
"ARMATG01",
"ARMATG02",
"ARMATG03",
"ARREDI01",
"ARROHI",
"ATU2NUCL",
"ATUCNUCL",
"AVALTG21",
"AVALTG22",
"AVALTG23",
"AVALTV11",
"AVALTV12",
"AVELDI01",
"BAHIEO",
"BANDDI01",
"BANDEO",
"BARDDI01",
"BARIDI01",
"BARKTG01",
"BATLTV03",
"BATLTV04",
"BATLTV05",
"BATLTV06",
"BBLATV29",
"BBLATV30",
"BBLMDI01",
"BBLMDI02",
"BBLMDI03",
"BBLMDI04",
"BBLMDI05",
"BBLMDI06",
"BERIDI01",
"BIC2EO",
"BRAGTG01",
"BRAGTG02",
"BRAGTG03",
"BRAGTG04",
"BRAGTG05",
"BRAGTG06",
"BRANDI01",
"BRC1DI01",
"BRC1DI02",
"BRC2DI01",
"BRC2DI02",
"BRCHTG01",
"BRKETG01",
"BRKETG02",
"BRKETG03",
"BRKETG04",
"BROWTG01",
"BROWTG02",
"BSASTG01",
"BSASTV01",
"BVILDI01",
"CACHHI",
"CADIHI",
"CAFAFV",
"CAIMDI01",
"CAIMDI02",
"CAIMDI03",
"CAIMDI04",
"CAIMDI05",
"CALEHI",
"CALOFV",
"CARLDI01",
"CARRHI",
"CASBDI01",
"CASSHI",
"CASTDI01",
"CATADI01",
"CATDDI01",
"CAVIDI01",
"CBMODI01",
"CCASDI01",
"CCOLHI",
"CCORHI",
"CDPITG21",
"CEJEHI",
"CEM1HI01",
"CEM1TI01",
"CEM2HI01",
"CEM2TI01",
"CEPUTG11",
"CEPUTG12",
"CEPUTV10",
"CEREDI01",
"CERITV01",
"CESPHI",
"CGOMDI01",
"CGOMDI02",
"CGOMDI03",
"CGOMDI04",
"CHARDI01",
"CHARDI02",
"CHEPDI01",
"CHEPFV",
"CHI1FV",
"CHILDI01",
"CHLEDI01",
"CHNOEO",
"CHOCHI",
"CIPODI01",
"CIPOHI",
"COLBDI01",
"CONDHI",
"COROHI",
"CORRDI01",
"CORTEO",
"COSMDI11",
"COSTTG08",
"COSTTG09",
"COSTTV01",
"COSTTV02",
"COSTTV03",
"COSTTV04",
"COSTTV06",
"COSTTV07",
"COSTTV10",
"CPIEHI",
"CRIVTG21",
"CRIVTG22",
"CRIVTG23",
"CRIVTG26",
"CRIVTG27",
"CRIVTG28",
"CRIVTV25",
"CSARDI01",
"CUM2FV",
"CUMBFV",
"CURUTG01",
"CURUTG02",
"CVIEHI",
"DFUNDI01",
"DFUNTG01",
"DFUNTG02",
"DIA2EO",
"DIADEO",
"DIQUTG01",
"DIQUTG02",
"DIQUTG03",
"DIQUTG04",
"DORAIN",
"DSUDTG07",
"DSUDTG08",
"DSUDTG09",
"DSUDTG10",
"DSUDTV11",
"EBARTG01",
"EBARTG02",
"ELOMDI01",
"EMBANUCL",
"ENRSDI01",
"ENSETG01",
"ESCAHI",
"ETIGHI",
"EZEITG01",
"EZEITG02",
"EZEITG03",
"FILOTG01",
"FILOTG02",
"FILOTG03",
"FORDDI01",
"FORDDI02",
"FRIATG01",
"FRIATG21",
"FSIMHI",
"FUTAHI",
"GARAEO",
"GBELTG01",
"GBELTG02",
"GBELTV01",
"GCRSDI01",
"GEBATG01",
"GEBATG02",
"GEBATG03",
"GEBATG04",
"GEBATV01",
"GOYATG21",
"GOYDDI01",
"GUAMDI01",
"GUARIN",
"GUEMTG01",
"GUEMTV11",
"GUEMTV12",
"GUEMTV13",
"HON1FV",
"HON2FV",
"HON3FV",
"HUEMDI01",
"HUMADI01",
"IGLEFV",
"IMACE1UR",
"IMACE2UR",
"IMACH1BR",
"IMACH2BR",
"IMACPLBR",
"IMACT1BR",
"IMACT1CH",
"IMACT2BR",
"IMBREXUR",
"IMEMBRUR",
"IMEMH1BR",
"IMEMH2BR",
"IMEMT1BR",
"IMEMT1CH",
"IMEMT2BR",
"INDETG01",
"INDETG02",
"INDETG03",
"INDETG04",
"INTADI01",
"ISBATV01",
"ISVEDI01",
"ITATDI01",
"JUARDI01",
"JUMEEO",
"JUNIDI01",
"LBANTG21",
"LBANTG22",
"LBLADI01",
"LCA2EO",
"LCA2TG01",
"LCAMTG01",
"LCASEO",
"LDCUHI",
"LDCUTG22",
"LDCUTG23",
"LDCUTG24",
"LDCUTG25",
"LDCUTG26",
"LDCUTG27",
"LDCUTV11",
"LDCUTV12",
"LDCUTV14",
"LDCUTV15",
"LDLATG01",
"LDLATG02",
"LDLATG03",
"LDLATG04",
"LDLATG05",
"LDLATV01",
"LDLMDI01",
"LEDETV01",
"LEVADI01",
"LEVATG01",
"LEVATG02",
"LEVATG03",
"LEVATG04",
"LIBEDI01",
"LINCDI01",
"LLANFV",
"LLOMFV",
"LMADHI",
"LMO1HI",
"LMO2HI",
"LOBODI01",
"LOM4EO",
"LPALDI01",
"LPAZDI01",
"LPLADI01",
"LQUIHI",
"LREYHB",
"LRIDDI01",
"LRIODI",
"LRIOTG21",
"LRIOTG22",
"LRIOTG23",
"LRIOTG24",
"LRIPDI01",
"LRISDI01",
"LROBDI01",
"LUJAHI",
"LUJBTG01",
"LUJBTG02",
"LVARDI01",
"LVICDI01",
"LVINHI",
"MAGDDI01",
"MALDTG01",
"MALLDI01",
"MANAEO",
"MANBDI01",
"MAT3TG01",
"MAT3TG02",
"MAT3TG03",
"MAT3TG04",
"MATETG01",
"MATETG02",
"MATETG03",
"MATETG04",
"MATETG05",
"MATETG06",
"MATETG07",
"MATETG08",
"MATETG09",
"MATETG10",
"MATHTG01",
"MATHTG02",
"MDAJTG15",
"MDAJTG17",
"MDPATG12",
"MDPATG13",
"MDPATG19",
"MDPATG20",
"MDPATG21",
"MDPATG22",
"MDPATG23",
"MDPATG24",
"MDPATV07",
"MDPATV08",
"MESEDI01",
"MILADI01",
"MIR1DI01",
"MJUADI01",
"MMARTG01",
"MMARTG02",
"MMARTG03",
"MMARTG04",
"MMARTG05",
"MMARTG06",
"MMARTG07",
"MOLITV01",
"MSEVTG01",
"NECOEO",
"NECOTV01",
"NECOTV02",
"NECOTV03",
"NECOTV04",
"NESPDI02",
"NIDETV",
"NIH1HI",
"NIH2HI",
"NIH3HI",
"NIH4HI",
"NONOFV",
"NPUETV04",
"NPUETV05",
"NPUETV06",
"OBERTG01",
"OCAMDI01",
"OCAMDI02",
"OCAMDI03",
"OCAMDI04",
"OCAMDI05",
"OLADTG01",
"OLADTG02",
"OLAVDI01",
"OLPADI01",
"ORADDI01",
"PAGUHI",
"PAMEEO",
"PARATG01",
"PARATG02",
"PASIFV",
"PATATG01",
"PATATG02",
"PATATV01",
"PBANHI",
"PEDRTG01",
"PEDRTG02",
"PERZDI01",
"PERZDI02",
"PERZDI03",
"PERZDI04",
"PERZDI05",
"PERZDI06",
"PERZDI07",
"PERZDI08",
"PESPTV01",
"PHDZTG01",
"PHUITG01",
"PICADI01",
"PILATG11",
"PILATG12",
"PILATV01",
"PILATV02",
"PILATV03",
"PILATV04",
"PILATV10",
"PILBDI01",
"PILBDI02",
"PILBDI03",
"PILBDI04",
"PILBDI05",
"PILBDI06",
"PINATG07",
"PINATG08",
"PINATG09",
"PINATG10",
"PIQIDI01",
"PIRADI01",
"PLIBIN",
"PMA1EO",
"PMA2EO",
"PMADTG21",
"PMADTG22",
"PMORHI",
"PNEGHI",
"PNUETV07",
"PNUETV08",
"PNUETV09",
"POM1EO",
"POM2EO",
"POSAIN",
"POSATG02",
"PPATDI01",
"PPLEHI",
"PPNOTG01",
"PPNOTG02",
"PROCDI01",
"PRODTV01",
"PROVTV01",
"PTIGTG01",
"PTIGTG02",
"PTIGTG03",
"PTIGTG04",
"PTIGTG05",
"PTIGTG06",
"PTR1TG23",
"PTR1TG24",
"PTR1TG25",
"PUANDI01",
"PUPITV01",
"PVIEHI",
"PZUEDI01",
"QULLHI",
"RAFADI01",
"RAW1EO",
"RAW2EO",
"RAW3EO",
"RCHITG01",
"RCHITG02",
"RCHITG03",
"RCUATG01",
"RCUATG02",
"REALDI01",
"RENOTG01",
"REOLHI",
"RESCDI01",
"RESCHI",
"RGDEHB",
"RHONHI",
"ROCATG01",
"ROCATV01",
"ROJOTG01",
"ROJOTG02",
"ROJOTG03",
"ROJOTG04",
"ROMEHI",
"RREYHI",
"RSAUDI01",
"RTERTG01",
"RTERTG02",
"RTURTV01",
"RTURTV02",
"RUFIDI01",
"SAL2TG01",
"SALOHI",
"SANADI01",
"SANDHI",
"SARCTG21",
"SARCTG22",
"SARCTG23",
"SAUJFV",
"SBAYDI01",
"SCHADI01",
"SCTPDI01",
"SEMINO",
"SERTTG01",
"SFR2DI01",
"SFRATG01",
"SFRATG02",
"SGDEHIAR",
"SGUIHI",
"SHELTG01",
"SJU2FV",
"SJUAFV",
"SLTADI01",
"SMANDI01",
"SMARDI01",
"SMARHI",
"SMIGDI01",
"SMTUTG01",
"SMTUTG02",
"SMTUTV01",
"SNICTG01",
"SNICTV11",
"SNICTV12",
"SNICTV13",
"SNICTV14",
"SNICTV15",
"SOESTG01",
"SOESTG02",
"SOESTG03",
"SOESTG04",
"SOLATG01",
"SORRTV11",
"SORRTV12",
"SORRTV13",
"SPE2DI01",
"SPENDI01",
"SPEVDI01",
"SROQHI",
"SROSDI01",
"SSALDI01",
"SVICDI01",
"TABATV01",
"TABLTG01",
"TABLTG02",
"TANDTG01",
"TANDTG02",
"TANDTV01",
"TELLDI01",
"TERVDI01",
"TICITV01",
"TIMBTG01",
"TIMBTG02",
"TIMBTV01",
"TIN2FV",
"TINODI01",
"TINOFV",
"TORDEO",
"TORNDI01",
"TRAPTG01",
"TUCUTG01",
"TUCUTG02",
"TUCUTV01",
"TUNAHI",
"UL42FV",
"ULL3FV",
"ULL4FV",
"ULLUHI",
"ULN1FV",
"ULN2FV",
"UTEIEOLI",
"UTEIHICO",
"UTEIHIPA",
"UTEIHIRN",
"UTEIHISG",
"UTEINTAC",
"VANGDI01",
"VGADDI01",
"VGEPDI01",
"VGESTG11",
"VGESTG14",
"VGESTG16",
"VGESTG18",
"VIALDI01",
"VLO2EO",
"VLONEO",
"VMA2TG01",
"VMA2TG02",
"VMA2TG03",
"VMA2TG04",
"VMARTG01",
"VMARTG02",
"VMARTG03",
"VOBLTG01",
"VOBLTG02",
"VOBLTV01",
"VTUDDI01",
"YACYHI",
"YANQDI01",
"YPFATG01",
"ZAPATG01",
"ZAPATG02",
"ZAPATG03",
"ZAPATG04",
"ZARATG01",
"ZARATG02",
"ZARATG03",
"ZARATG04");
        cb_grupo.setValue("3ARRDI01");
    }    
    
}
