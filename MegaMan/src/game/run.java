package game;

public class run {

    public static void main(String[] args)
    {
        ApplicationManager appManager = ApplicationManager.getInstance();
        appManager.setup();
//        appManager.flash();

        ImageLoader load = new ImageLoader("/assets/");
        System.out.println(load.size());
    }

}
