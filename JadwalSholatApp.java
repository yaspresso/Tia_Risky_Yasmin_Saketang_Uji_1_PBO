// [1] Abstract Class Prayer
abstract class Prayer {
    protected String name;
    protected String time;
    
    public Prayer(String name, String time) {
        this.name = name;
        this.time = time;
    }
    
    public abstract void remind();
}

// [2] Interface AudioReminder
interface AudioReminder {
    void playAdhan();
}

// [3] Subclass untuk 5 Sholat Wajib
class Fajr extends Prayer implements AudioReminder {
    public Fajr(String time) {
        super("Subuh", time);
    }
    
    @Override
    public void remind() {
        System.out.println("⏰ " + name + " " + time + " - Bangunlah, dunia masih gelap!");
    }
    
    @Override
    public void playAdhan() {
        System.out.println("🔊 Adzan Subuh berkumandang... Faalaa takunuu minal ghoofiliin");
    }
}

class Dhuhr extends Prayer {
    public Dhuhr(String time) {
        super("Dzuhur", time);
    }
    
    @Override
    public void remind() {
        System.out.println("☀️ " + name + " " + time + " - Saat matahari tergelincir!");
    }
}

class Asr extends Prayer {
    public Asr(String time) {
        super("Ashar", time);
    }
    
    @Override
    public void remind() {
        System.out.println("🌇 " + name + " " + time + " - Bayangan sudah panjang!");
    }
}

class Maghrib extends Prayer implements AudioReminder {
    public Maghrib(String time) {
        super("Maghrib", time);
    }
    
    @Override
    public void remind() {
        System.out.println("🌆 " + name + " " + time + " - Buka puasa yuk!");
    }
    
    @Override
    public void playAdhan() {
        System.out.println("🔊 Adzan Maghrib... Allahu Akbar!");
    }
}

class Isha extends Prayer implements AudioReminder {
    public Isha(String time) {
        super("Isya", time);
    }
    
    @Override
    public void remind() {
        System.out.println("🌃 " + name + " " + time + " - Gelap sudah menyelimuti!");
    }
    
    @Override
    public void playAdhan() {
        System.out.println("🔊 Adzan Isya... Hayya 'alash sholaah!");
    }
}

// [4] Main App
public class JadwalSholatApp {
    public static void main(String[] args) {
        Prayer[] jadwal = {
            new Fajr("04:30"),
            new Dhuhr("12:15"),
            new Asr("15:30"),
            new Maghrib("18:00"),
            new Isha("19:30")
        };
        
        for (Prayer p : jadwal) {
            p.remind();
            if (p instanceof AudioReminder) {
                ((AudioReminder)p).playAdhan();
            }
            System.out.println("------------------");
        }
    }
}
