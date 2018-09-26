package com.a1989gmail.er.poor.veszelyesanyagok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

   /* private int EricardSubkey;
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
*/
    //Miki kódja

    public class DbConnect extends SQLiteOpenHelper {


        // ADATBÁZIS FELÉPÍTÉSE

        public static final String DATABASE_NAME = "veszelyesanyagok.db";     //ADATBÁZIS FILE NEVE
        public static final String TABLE_NAME = "substances";     //TÁBLA NEVE
        public static final int DATABASE_VERSION = 1;

        public static final String COL_1 = "id";
        public static final String COL_2 = "ericard_subkey";
        public static final String COL_3 = "anyagnev";
        public static final String COL_4 = "un_szam";
        public static final String COL_5 = "veszely_jel";
        public static final String COL_6 = "adr_veszelyessegi_barca_szama";
        public static final String COL_7 = "adr_veszelyessegi_osztaly";
        public static final String COL_8 = "ericards_hivatkozasi_szam";
        public static final String COL_9 = "informacio_veszhelyzetben_valo_beavatkozashoz";
        public static final String COL_10 = "jellemzo_tulajdonsagai";
        public static final String COL_11 = "veszelyek";
        public static final String COL_12 = "szemelyvedelem";
        public static final String COL_13 = "beavatkozasi_tevekenyseg";
        public static final String COL_14 = "elsosegelynyujtas";
        public static final String COL_15 = "alapveto_ovintezkedesek_osszegyujteshez";
        public static final String COL_16 = "ovintezkedesek_a_beavatkozas_utan";

        public DbConnect(Context context){
            super(context,DATABASE_NAME,null,1);
            SQLiteDatabase db = this.getWritableDatabase();
            Log.wtf("Dbconnect", "Elindult");
        }

       /* private class DatabaseOpenHelper extends SQLiteOpenHelper {
            DatabaseOpenHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }
        }*/

        //LÉTREHOZZUK A TÁBLÁT ÉS A BENNE LÉVŐ OSZLOPOKHOZ TÍPUST ADUNK
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE if not EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, ericard_subkey TEXT, anyagnev TEXT, un_szam INTEGER, veszely_jel TEXT, adr_veszelyessegi_barca_szama TEXT, adr_veszelyessegi_osztaly TEXT, ericards_hivatkozasi_szam TEXT, informacio_veszhelyzetben_valo_beavatkozashoz TEXT, jellemzo_tulajdonsagai TEXT, veszelyek TEXT, szemelyvedelem TEXT, beavatkozasi_tevekenyseg TEXT, elsosegelynyujtas TEXT, alapveto_ovintezkedesek_osszegyujteshez TEXT, ovintezkedesek_a_beavatkozas_utan TEXT)");
            Log.wtf("dbconnect", "létrejött az adatbázis");
            insertData();

        }

        //DOBJA EL A TÁBLÁT HA MÁR ILYEN LÉTEZIK
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        //ADAT FELVÉTEL
        public boolean adatRogzites(String ericardSubkey, String anyagnev, int unSzam, String veszelyJel, String adrVeszelyessegiBarcaSzama, String adrVeszelyessegiOsztaly, String ericardsHivatkozasiSzam, String informacioVeszhelyzetbenValoBeavatkozashoz, String jellemzoTulajdonsagai, String veszelyek, String szemelyvedelem, String beavatkozasiTevekenyseg, String elsosegelynyujtas, String alapvetoOvintezkedesekOsszegyujteshez, String ovintezkedesekABeavatkozasUtan) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2,ericardSubkey);
            contentValues.put(COL_3,anyagnev);
            contentValues.put(COL_4,unSzam);
            contentValues.put(COL_5,veszelyJel);
            contentValues.put(COL_6,adrVeszelyessegiBarcaSzama);
            contentValues.put(COL_7,adrVeszelyessegiOsztaly);
            contentValues.put(COL_8,ericardsHivatkozasiSzam);
            contentValues.put(COL_9,informacioVeszhelyzetbenValoBeavatkozashoz);
            contentValues.put(COL_10,jellemzoTulajdonsagai);
            contentValues.put(COL_11,veszelyek);
            contentValues.put(COL_12,szemelyvedelem);
            contentValues.put(COL_13,beavatkozasiTevekenyseg);
            contentValues.put(COL_14,elsosegelynyujtas);
            contentValues.put(COL_15,alapvetoOvintezkedesekOsszegyujteshez);
            contentValues.put(COL_16,ovintezkedesekABeavatkozasUtan);

            long result = db.insert(TABLE_NAME,null,contentValues);

            if (result == -1){
                return false;       //sikertelen felvétel esetén false eredményt add vissza
            }else{
                return true;       //sikeres felvétel esetén true eredményt add vissza
            }
        }

        //ADAT TÖRLÉS
        public Integer adatTorles(String id)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            int i = db.delete(TABLE_NAME, "ID=?", new String[]{id});
            return i;
        }

        //TODO: adatok felvétele
        public void insertData ()
        {
            try {
                SQLiteDatabase db = getWritableDatabase();
                db.execSQL("INSERT INTO substances VALUES ('00040001','AMMÓNIUM-PIKRÁT, száraz vagy 10 tömeg%-nál kevesebb vízzel nedvesített','0004',' ','1','1','1-01','ROBBANÓANYAGOK ÉS ÁRUCIKKEK TÖMEGROBBANÁS VESZÉLYÉVEL ( 1.1 OSZTÁLY )','<ul>\\n <li>Robbanóanyagok vagy robbanóanyagokat tartalmazó árucikkek (pl. lőszer).</li>\\n <li>Járulékos mérgező vagy maró hatása lehet.</li>\\n</ul>\\n','<ul>\\n <li>Hő vagy tűz hatására a tömegrobbanás veszélye, azonnal kiterjedve majdnem a teljes rakományra.</li>\\n <li>Szétszóródás veszélye: nagy sebességű töredékek vagy égő törmelékek másodlagos tüzeket okozhatnak.</li>\\n <li>Robbanásveszély</li>\\n <li>A heves robbanási lökéshullám súlyos sérüléseket okozhat több száz méteres körzetben pl. üvegszilánkok.</li>\\n <li>Tűz esetén mérgező vagy maró gőzöket bocsáthat ki.</li>\\n</ul>\\n','<ul>\\n <li>Környezettől független légzőkészülék.</li>\\n</ul>\\n','<h3>4.1 Általános</h3>\\n<ul>\\n <li>A dohányzás tilos, távolítsuk el a gyújtóforrásokat. Ne használjunk elektromos készülékeket a szállítmány közelében.</li>\\n <li>Tartsunk védőtávolságot és haladéktalanul használjunk ki minden alkalmas védett helyszínt.</li>\\n <li>LAKOSSÁGI BIZTONSÁGI INTÉZKEDÉS - Figyelmeztessük a közelben tartózkodókat és haladéktalanul távolítsuk el a veszélyes területen tartózkodókat.</li>\\n <li>Minimalizáljuk a személyzet létszámát a veszélyeztetett területen.</li>\\n <li>Ne érintsük meg a leejtett vagy ledobott anyagot vagy árút.</li>\\n <li>Ha szükséges, értesítsük az illetékes hatóságokat.</li>\\n</ul>\\n<h3>4.2 Kiáramlás</h3>\\n<ul>\\n <li>Ne tegyünk intézkedéseket! Haladéktalanul kérjük szakértő tanácsát.</li>\\n <li>Ha az anyag élővízbe vagy csatornába jutott, tájékoztassuk a felelős hatóságokat.</li>\\n</ul>\\n<h3>4.3 Tűz (kiterjedve a szállítmányra)</h3>\\n<ul>\\n <li>NE OLTSUK EL A TÜZET, hagyjuk égni.</li>\\n <li>A tüzet oltsuk el bármilyen rendelkezésre álló eszközzel, ha az még nem érte el a szállítmányt.</li>\\n <li>Biztonságos helyről dolgozzunk a személyzet kockázatának csökkentése érdekében. Használjunk kezelőszemélyzetet nem igénylő ágyúkat vagy sugarakat.</li>\\n <li>Ürítsük ki a veszélyeztetett területet egy legalább 1000 m sugarú kör mentén.</li>\\n <li>A beavatkozó erőket tartsuk távol a veszélyeztetett területtől legalább 500 m sugarú körben.</li>\\n <li>A területet tartsuk szabadon és biztosítsunk felügyeletet legalább 6 órán keresztül.</li>\\n</ul>\\n','<ul>\\n <li>Égési sérülés esetén az érintett bőrfelületet azonnal hűtsük hideg vízzel amilyen hosszan csak lehetséges. A bőrre tapadt ruházatot ne távolítsuk el.</li>\\n <li>Haladéktalanul orvosi megfigyelés alá kell helyezni azokat a személyeket, akik kapcsolatba kerültek az anyaggal, vagy gőzét belélegezték. Minden fellelhető anyaginformációt továbbítani kell.</li>\\n</ul>\\n','<ul>\\n <li>Ne használjuk a megszokott gyógyító felszereléseket. Haladéktalanul kérjük szakértő tanácsát.</li>\\n</ul>\\n','<h3>7.1 Kivetkőzés</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát a mentesítési eljáráshoz.</li>\\n</ul>\\n<h3>7.2 Felszerelés megtisztítása</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát mielőtt elhagynánk a baleset helyszínét.</li>\\n</ul>\\n')");
                //db.execSQL("INSERT INTO substances VALUES ('00050002','TÖLTÉNYEK FEGYVEREKHEZ robbanólövedékkel','0005','','1','1','1-01','ROBBANÓANYAGOK ÉS ÁRUCIKKEK TÖMEGROBBANÁS VESZÉLYÉVEL ( 1.1 OSZTÁLY )','<ul>\\n <li>Robbanóanyagok vagy robbanóanyagokat tartalmazó árucikkek (pl. lőszer).</li>\\n <li>Járulékos mérgező vagy maró hatása lehet.</li>\\n</ul>\\n','<ul>\\n <li>Hő vagy tűz hatására a tömegrobbanás veszélye, azonnal kiterjedve majdnem a teljes rakományra.</li>\\n <li>Szétszóródás veszélye: nagy sebességű töredékek vagy égő törmelékek másodlagos tüzeket okozhatnak.</li>\\n <li>Robbanásveszély</li>\\n <li>A heves robbanási lökéshullám súlyos sérüléseket okozhat több száz méteres körzetben pl. üvegszilánkok.</li>\\n <li>Tűz esetén mérgező vagy maró gőzöket bocsáthat ki.</li>\\n</ul>\\n','<ul>\\n <li>Környezettől független légzőkészülék.</li>\\n</ul>\\n','<h3>4.1 Általános</h3>\\n<ul>\\n <li>A dohányzás tilos, távolítsuk el a gyújtóforrásokat. Ne használjunk elektromos készülékeket a szállítmány közelében.</li>\\n <li>Tartsunk védőtávolságot és haladéktalanul használjunk ki minden alkalmas védett helyszínt.</li>\\n <li>LAKOSSÁGI BIZTONSÁGI INTÉZKEDÉS - Figyelmeztessük a közelben tartózkodókat és haladéktalanul távolítsuk el a veszélyes területen tartózkodókat.</li>\\n <li>Minimalizáljuk a személyzet létszámát a veszélyeztetett területen.</li>\\n <li>Ne érintsük meg a leejtett vagy ledobott anyagot vagy árút.</li>\\n <li>Ha szükséges, értesítsük az illetékes hatóságokat.</li>\\n</ul>\\n<h3>4.2 Kiáramlás</h3>\\n<ul>\\n <li>Ne tegyünk intézkedéseket! Haladéktalanul kérjük szakértő tanácsát.</li>\\n <li>Ha az anyag élővízbe vagy csatornába jutott, tájékoztassuk a felelős hatóságokat.</li>\\n</ul>\\n<h3>4.3 Tűz (kiterjedve a szállítmányra)</h3>\\n<ul>\\n <li>NE OLTSUK EL A TÜZET, hagyjuk égni.</li>\\n <li>A tüzet oltsuk el bármilyen rendelkezésre álló eszközzel, ha az még nem érte el a szállítmányt.</li>\\n <li>Biztonságos helyről dolgozzunk a személyzet kockázatának csökkentése érdekében. Használjunk kezelőszemélyzetet nem igénylő ágyúkat vagy sugarakat.</li>\\n <li>Ürítsük ki a veszélyeztetett területet egy legalább 1000 m sugarú kör mentén.</li>\\n <li>A beavatkozó erőket tartsuk távol a veszélyeztetett területtől legalább 500 m sugarú körben.</li>\\n <li>A területet tartsuk szabadon és biztosítsunk felügyeletet legalább 6 órán keresztül.</li>\\n</ul>\\n','<ul>\\n <li>Égési sérülés esetén az érintett bőrfelületet azonnal hűtsük hideg vízzel amilyen hosszan csak lehetséges. A bőrre tapadt ruházatot ne távolítsuk el.</li>\\n <li>Haladéktalanul orvosi megfigyelés alá kell helyezni azokat a személyeket, akik kapcsolatba kerültek az anyaggal, vagy gőzét belélegezték. Minden fellelhető anyaginformációt továbbítani kell.</li>\\n</ul>\\n','<ul>\\n <li>Ne használjuk a megszokott gyógyító felszereléseket. Haladéktalanul kérjük szakértő tanácsát.</li>\\n</ul>\\n','<h3>7.1 Kivetkőzés</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát a mentesítési eljáráshoz.</li>\\n</ul>\\n<h3>7.2 Felszerelés megtisztítása</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát mielőtt elhagynánk a baleset helyszínét.</li>\\n</ul>\\n')");
                //db.execSQL("INSERT INTO substances VALUES ('00060003','TÖLTÉNYEK FEGYVEREKHEZ robbanólövedékkel','0006','','1','1','1-01','ROBBANÓANYAGOK ÉS ÁRUCIKKEK TÖMEGROBBANÁS VESZÉLYÉVEL ( 1.1 OSZTÁLY )','<ul>\\n <li>Robbanóanyagok vagy robbanóanyagokat tartalmazó árucikkek (pl. lőszer).</li>\\n <li>Járulékos mérgező vagy maró hatása lehet.</li>\\n</ul>\\n','<ul>\\n <li>Hő vagy tűz hatására a tömegrobbanás veszélye, azonnal kiterjedve majdnem a teljes rakományra.</li>\\n <li>Szétszóródás veszélye: nagy sebességű töredékek vagy égő törmelékek másodlagos tüzeket okozhatnak.</li>\\n <li>Robbanásveszély</li>\\n <li>A heves robbanási lökéshullám súlyos sérüléseket okozhat több száz méteres körzetben pl. üvegszilánkok.</li>\\n <li>Tűz esetén mérgező vagy maró gőzöket bocsáthat ki.</li>\\n</ul>\\n','<ul>\\n <li>Környezettől független légzőkészülék.</li>\\n</ul>\\n','<h3>4.1 Általános</h3>\\n<ul>\\n <li>A dohányzás tilos, távolítsuk el a gyújtóforrásokat. Ne használjunk elektromos készülékeket a szállítmány közelében.</li>\\n <li>Tartsunk védőtávolságot és haladéktalanul használjunk ki minden alkalmas védett helyszínt.</li>\\n <li>LAKOSSÁGI BIZTONSÁGI INTÉZKEDÉS - Figyelmeztessük a közelben tartózkodókat és haladéktalanul távolítsuk el a veszélyes területen tartózkodókat.</li>\\n <li>Minimalizáljuk a személyzet létszámát a veszélyeztetett területen.</li>\\n <li>Ne érintsük meg a leejtett vagy ledobott anyagot vagy árút.</li>\\n <li>Ha szükséges, értesítsük az illetékes hatóságokat.</li>\\n</ul>\\n<h3>4.2 Kiáramlás</h3>\\n<ul>\\n <li>Ne tegyünk intézkedéseket! Haladéktalanul kérjük szakértő tanácsát.</li>\\n <li>Ha az anyag élővízbe vagy csatornába jutott, tájékoztassuk a felelős hatóságokat.</li>\\n</ul>\\n<h3>4.3 Tűz (kiterjedve a szállítmányra)</h3>\\n<ul>\\n <li>NE OLTSUK EL A TÜZET, hagyjuk égni.</li>\\n <li>A tüzet oltsuk el bármilyen rendelkezésre álló eszközzel, ha az még nem érte el a szállítmányt.</li>\\n <li>Biztonságos helyről dolgozzunk a személyzet kockázatának csökkentése érdekében. Használjunk kezelőszemélyzetet nem igénylő ágyúkat vagy sugarakat.</li>\\n <li>Ürítsük ki a veszélyeztetett területet egy legalább 1000 m sugarú kör mentén.</li>\\n <li>A beavatkozó erőket tartsuk távol a veszélyeztetett területtől legalább 500 m sugarú körben.</li>\\n <li>A területet tartsuk szabadon és biztosítsunk felügyeletet legalább 6 órán keresztül.</li>\\n</ul>\\n','<ul>\\n <li>Égési sérülés esetén az érintett bőrfelületet azonnal hűtsük hideg vízzel amilyen hosszan csak lehetséges. A bőrre tapadt ruházatot ne távolítsuk el.</li>\\n <li>Haladéktalanul orvosi megfigyelés alá kell helyezni azokat a személyeket, akik kapcsolatba kerültek az anyaggal, vagy gőzét belélegezték. Minden fellelhető anyaginformációt továbbítani kell.</li>\\n</ul>\\n','<ul>\\n <li>Ne használjuk a megszokott gyógyító felszereléseket. Haladéktalanul kérjük szakértő tanácsát.</li>\\n</ul>\\n','<h3>7.1 Kivetkőzés</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát a mentesítési eljáráshoz.</li>\\n</ul>\\n<h3>7.2 Felszerelés megtisztítása</h3>\\n<ul>\\n <li>Kérjük szakértő tanácsát mielőtt elhagynánk a baleset helyszínét.</li>\\n</ul>\\n')");
            }catch (SQLException e){
                final String message = e.getMessage();
            }

            Log.wtf("DBconnect", "Adatok felvétele sikeresen megtörtént");
        }

        public void onOpen(SQLiteDatabase db);


        public List<String> getAllLabels(){
            List<String> labels = new ArrayList<String>();

            // Select All Query
            String selectQuery = "SELECT un_szam FROM substances";

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    labels.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }

            // closing connection
            cursor.close();
            db.close();

            // returning lables
            return labels;
        }
    }
