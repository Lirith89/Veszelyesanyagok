package com.a1989gmail.er.poor.veszelyesanyagok;

public class DbConnect {

    private int EricardSubkey;
    private String Anyagnev;
    private int UnSzam;
    private String VeszelyJel;
    private  int AdrVeszelyessegiBarcaSzama;
    private  int AdrVeszelyessegiOsztaly;
    private  String EricardsHivatkozasiSzam;
    private String InformacioVeszhelyzetbenValoBeavatkozashoz;
    private String JellemzoTulajdonsagai;
    private String Veszelyek;
    private String Szemelyvedelem;
    private String BeavatkozasiTevekenyseg;
    private String Elsosegelynyujtas;
    private String AlapvetoOvintezkedesekOsszegyujteshez;
    private String OvintezkedesekABeavatkozasUtan;

    public DbConnect(){
    }

    public DbConnect(int ericardSubkey, String anyagnev, int unSzam, String veszelyJel, int adrVeszelyessegiBarcaSzama, int adrVeszelyessegiOsztaly, String ericardsHivatkozasiSzam, String informacioVeszhelyzetbenValoBeavatkozashoz, String jellemzoTulajdonsagai, String veszelyek, String szemelyvedelem, String beavatkozasiTevekenyseg, String elsosegelynyujtas, String alapvetoOvintezkedesekOsszegyujteshez, String ovintezkedesekABeavatkozasUtan) {
        EricardSubkey = ericardSubkey;
        Anyagnev = anyagnev;
        UnSzam = unSzam;
        VeszelyJel = veszelyJel;
        AdrVeszelyessegiBarcaSzama = adrVeszelyessegiBarcaSzama;
        AdrVeszelyessegiOsztaly = adrVeszelyessegiOsztaly;
        EricardsHivatkozasiSzam = ericardsHivatkozasiSzam;
        InformacioVeszhelyzetbenValoBeavatkozashoz = informacioVeszhelyzetbenValoBeavatkozashoz;
        JellemzoTulajdonsagai = jellemzoTulajdonsagai;
        Veszelyek = veszelyek;
        Szemelyvedelem = szemelyvedelem;
        BeavatkozasiTevekenyseg = beavatkozasiTevekenyseg;
        Elsosegelynyujtas = elsosegelynyujtas;
        AlapvetoOvintezkedesekOsszegyujteshez = alapvetoOvintezkedesekOsszegyujteshez;
        OvintezkedesekABeavatkozasUtan = ovintezkedesekABeavatkozasUtan;
    }

    public int getEricardSubkey() {
        return EricardSubkey;
    }

    public String getAnyagnev() {
        return Anyagnev;
    }

    public int getUnSzam() {
        return UnSzam;
    }

    public String getVeszelyJel() {
        return VeszelyJel;
    }

    public int getAdrVeszelyessegiBarcaSzama() {
        return AdrVeszelyessegiBarcaSzama;
    }

    public int getAdrVeszelyessegiOsztaly() {
        return AdrVeszelyessegiOsztaly;
    }

    public String getEricardsHivatkozasiSzam() {
        return EricardsHivatkozasiSzam;
    }

    public String getInformacioVeszhelyzetbenValoBeavatkozashoz() {
        return InformacioVeszhelyzetbenValoBeavatkozashoz;
    }

    public String getJellemzoTulajdonsagai() {
        return JellemzoTulajdonsagai;
    }

    public String getVeszelyek() {
        return Veszelyek;
    }

    public String getSzemelyvedelem() {
        return Szemelyvedelem;
    }

    public String getBeavatkozasiTevekenyseg() {
        return BeavatkozasiTevekenyseg;
    }

    public String getElsosegelynyujtas() {
        return Elsosegelynyujtas;
    }

    public String getAlapvetoOvintezkedesekOsszegyujteshez() {
        return AlapvetoOvintezkedesekOsszegyujteshez;
    }

    public String getOvintezkedesekABeavatkozasUtan() {
        return OvintezkedesekABeavatkozasUtan;
    }
}
