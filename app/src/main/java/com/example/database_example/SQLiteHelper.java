package com.example.database_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PRODUCTS = "products";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";

    public static final String[] PRODUCTS_COLUMN= {COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION, COLUMN_PRICE};



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PRODUCTS+" (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE +" TEXT NOT NULL, "
                + COLUMN_DESCRIPTION +" TEXT NOT NULL, "
                + COLUMN_PRICE +" REAL DEFAULT 0)");

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, "HP Envy x360 15 - eu0006nv Laptop 15.6 FHD IPS Αφής");
        values.put(COLUMN_DESCRIPTION, "Ισχύς, ακρίβεια χρωμάτων που τροφοδοτεί την δημιουργικότητά σου και προστασία της ιδιωτικότητας! Το HP Envy x360 είναι ο ψηφιακός «καμβάς» που ξεχωρίζει για τον πολύπλευρο και ανθεκτικό χαρακτήρα του. Εξοπλισμένο με τον πανίσχυρο 8πύρηνο AMD Ryzen™ 5700U, με 16 threads και χρονισμό που μπορεί να πιάσει τα 4,3 Ghz (max boost). Διαθέτει ενσωματωμένα γραφικά AMD Radeon™ και 16 GB DDR4-3200 MHz RAM. Έτσι, θα τρέξεις όλες τις εφαρμογές δημιουργικότητας που χρειάζεσαι είτε επεξεργάζεσαι εικόνα είτε video ή ήχο χωρίς κανένα πρόβλημα! Με την οθόνη 15,6” FHD (1920 x 1080) IPS Πολλαπλής αφής, με γυάλινη επιφάνεια Corning® Gorilla® Glass NBT™ από άκρη σε άκρη, φωτεινότητα 250 nits, 45%ΝTSC και με την επαναφορτιζόμενη γραφίδα HP MPP 2.0 Tilt που περιλαμβάνεται, μπορείς να αφήσεις την δημιουργικότητά σου ελεύθερη. Με βάρος μόλις 1,86 kg, μπαταρία λιθίου 51Wh και HP FastCharge, μπορείς να μεγαλουργήσεις όπου κι αν βρίσκεσαι, οποιαδήποτε στιγμή!");
        values.put(COLUMN_PRICE, 899.00);
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "Apple MacBook Air Retina MGN63GR/A (Late 2020) S.G. ");
        values.put(COLUMN_DESCRIPTION, "Power. It’s in the Air. Ο λεπτότερος, ελαφρύτερος φορητός υπολογιστής της Apple - το δημοφιλές και αγαπημένο MacBook Air 13,3” - μεταμορφώθηκε πλήρως από τον πανίσχυρο 8πύρηνο επεξεργαστή M1.Στο σπίτι ή στο γραφείο, ο νέος επαναστατικός επεξεργαστής Apple M1 μεταμορφώνει την επιφάνεια εργασίας και σε μεταφέρει σε μία νέα διάσταση συναρπαστικών δυνατοτήτων, με έως και 3,5x υψηλότερη απόδοση CPU, έως και 5x ταχύτερη απόδοση γραφικών και την πιο εξελιγμένη νευρονική μηχανή (Neural Engine) για έως και 9x ταχύτερη, πιο αξιόπιστη, μηχανική εκμάθηση Η μεγαλύτερη διάρκεια ζωής της μπαταρίας σε MacBook Air. Μία εντελώς αθόρυβη - χωρίς ανεμιστήρα - σχεδίαση. Ποτέ άλλοτε μία τόσο μεγάλη δύναμη επεξεργαστικής ισχύος δεν υπήρξε σε μία τόσο ready-to-go υλοποίηση!");
        values.put(COLUMN_PRICE, 1279.00);
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "HP 15s eq2017nv Laptop 15.6 IPS");
        values.put(COLUMN_DESCRIPTION, "Ο φορητός υπολογιστής 15s-eq2017nv προσφέρει αξιόπιστη απόδοση για streaming, περιήγηση και άνετη εργασία, ώστε να έχεις απρόσκοπτη παραγωγικότητα και ψυχαγωγία, όπου κι αν βρίσκεσαι!Βασίζεται στον επεξεργαστή AMD Ryzen™ 5 5500U (με έξι πυρήνες, δώδεκα νήματα, συχνότητα λειτουργίας 2,1GHz έως 4,0 GHz και με ενσωματωμένα γραφικά AMD Radeon™) ο οποίος πλαισιώνεται από 16 GB μνήμης DDR4-3200 για αποδοτικό multitasking και από την αποθηκευτική μονάδα NVMe M.2 SSD με χωρητικότητα 512 GB, για ταχύτατη εκκίνηση και άμεση απόκριση σε ό,τι κι αν κάνεις.«Οδηγώντας» την αντιθαμβωτική οθόνη IPS Full HD (1.920 x 1.080 pixels) με πλαίσιο Micro-Edge, η ενσωματωμένη στον επεξεργαστή κάρτα γραφικών AMD Radeon™ Graphics είναι ικανή να ανταποκριθεί σε απαιτητικές εφαρμογές ενώ αποδίδει ικανοποιητικά και στο casual gaming. Με Windows 11 Home (S Mode) και βάρος 1,69 κιλά, μπορείς να τον μεταφέρεις παντού με ευκολία!");
        values.put(COLUMN_PRICE, 639.00);
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "HP 15s-eq1022nv Laptop 15.6 Full HD");
        values.put(COLUMN_DESCRIPTION, "Ο φορητός υπολογιστής 15s-eq1022nv προσφέρει αξιόπιστη απόδοση για streaming, περιήγηση και άνετη εργασία, ώστε να έχεις απρόσκοπτη παραγωγικότητα και ψυχαγωγία, όπου κι αν βρίσκεσαι!                Βασίζεται στον επεξεργαστή AMD Athlon™ Silver 3050U (δύο πυρήνες, δύο νήματα, έως 3,2 GHz και με ενσωματωμένα γραφικά AMD Radeon™) ο οποίος πλαισιώνεται από 8 GB μνήμης DDR4-2400 για αποδοτικό multitasking και από την αποθηκευτική μονάδα NVMe M.2 SSD με χωρητικότητα 256 GB, για ταχύτατη εκκίνηση και άμεση απόκριση σε ό,τι κι αν κάνεις.«Οδηγώντας» την αντιθαμβωτική οθόνη IPS Full HD (1.920 x 1.080 pixels) με πλαίσιο Micro-Edge, η ενσωματωμένη στον επεξεργαστή κάρτα γραφικών AMD Radeon™ Graphics είναι ικανή να ανταποκριθεί σε απαιτητικές εφαρμογές ενώ αποδίδει ικανοποιητικά και στο casual gaming. Με Windows 11 (S Mode) και βάρος 1,69 κιλά, μπορείς να τον μεταφέρεις παντού με ευκολία!");
        values.put(COLUMN_PRICE, 349.00);
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "HP Pavilion Gaming 15-ec2003nv Laptop 15.6 Full HD IPS");
        values.put(COLUMN_DESCRIPTION, "O λεπτός και ισχυρός φορητός υπολογιστής HP Pavilion Gaming 15-ec2003nv σχεδιάστηκε για να απολαμβάνεις κορυφαία γραφικά και επεξεργαστική ισχύ στα παιχνίδια και κορυφαία απόδοση στην εκτέλεση πολλαπλών εργασιών.Με συμπαγές σασί, μικρό πλαίσιο οθόνης, οπισθοφωτιζόμενο πληκτρολόγιο, «ταχύτατη» οθόνη 15,6 ιντσών (144Hz) και ισχυρό hardware, ο HP Pavilion Gaming 15-ec2003nv έχει όλα όσα χρειάζεσαι για να απολαμβάνεις το παιχνίδι χωρίς συμβιβασμούς.Στο εσωτερικό του βρίσκεται ο οκταπύρηνος επεξεργαστής AMD Ryzen™ 7 5800H στα 3,2 GHz (Max Boost Clock 4,4 GHz) σε συνδυασμό με την ανεξάρτητη κάρτα γραφικών NVIDIA® GeForce® RTX 3050 4GB GDDR6, 16GB μνήμης DDR4-3200 και το ταχύτατο PCIe® NVMe™ M.2 SSD χωρητικότητας 512 GB.Απόλαυσε υψηλά framerates και κορυφαία ποιότητα απεικόνισης χωρίς συμβιβασμούς με τον φορητό υπολογιστή HP Pavilion Gaming 15-ec2003nv.");
        values.put(COLUMN_PRICE, 999.00);
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
