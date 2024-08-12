public class Computer {

    public String motherboard;
    public String videoCard;
    public Integer gbRam;
    public String processor;
    public String cabinetColor;
    public Integer gbSSD;
    public String font;
    public Boolean turnOn = false;

    public Computer(String motherboard, String videoCard, Integer gbRam, String processor, String cabinetColor,
            Integer gbSSD, String font) {
        this.motherboard = motherboard;
        this.videoCard = videoCard;
        this.gbRam = gbRam;
        this.processor = processor;
        this.cabinetColor = cabinetColor;
        this.gbSSD = gbSSD;
        this.font = font;
    }

    public void turnOn(){
        turnOn = false;
        System.out.println(gbRam + " " + processor + " " + "Welcome!");
    }
    

}
