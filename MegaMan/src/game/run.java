package game;

public class run {

    public static void main(String[] args)
    {
        GameManager gameManager = GameManager.getInstance();
        gameManager.setup();
        gameManager.flash();
    }

}
