package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static Utils.Definitions.getElement;

public class Main_Arts {



    public static By mainArts = By.xpath("//span[@class='font-bold'][contains(text(),'Ana Resimler')]");


    public Main_Arts() throws IOException {
        URL listImage1 = new URL(Get_listImg1().getAttribute("src"));
        HttpURLConnection connectionListIMG1 = (HttpURLConnection) listImage1.openConnection();
        connectionListIMG1.setRequestMethod("GET");
        connectionListIMG1.connect();
        int codeListImage1 = connectionListIMG1.getResponseCode();
    }



    public static WebElement Get_mainArts() {
        return getElement(mainArts);
    }

    public static By btn_AddMainArts = By.id("btn_addMainArt");

    public static WebElement Get_btn_AddMainArts() {
        return getElement(btn_AddMainArts);
    }

    public static By btn_uploadImage = By.xpath("//main//div[1]//div[1]//div[1]//div[2]//input[1]");

    public static WebElement Get_btn_uploadImage() {
        return getElement(btn_uploadImage);
    }

    public static String uploadMainArtFolder = "C:\\Users\\sercan.elmas\\Pictures\\düdüt\\t1.jpg";


    public static By img1 = By.xpath("/html[1]/body[1]/div[1]/div[1]/main-art-create-edit[1]/div[1]/main[1]/div[1]/img[1]");

    public static WebElement Get_img1() {
        return getElement(img1);
    }

    public static By img2 = By.xpath("/html[1]/body[1]/div[1]/div[1]/main-art-create-edit[1]/div[1]/main[1]/div[2]/img[1]");

    public static WebElement Get_img2() {
        return getElement(img2);
    }

    public static By img3 = By.xpath("/html[1]/body[1]/div[1]/div[1]/main-art-create-edit[1]/div[1]/main[1]/div[3]/img[1]");

    public static WebElement Get_img3() {
        return getElement(img3);
    }

    public static By btn_save = By.id("btn_save");

    public static WebElement Get_btn_save() {
        return getElement(btn_save);
    }

    public static By listImg1 = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/main-art-list[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/img[1]");

    public static WebElement Get_listImg1() {
        return getElement(listImg1);
    }

    public static By listImg2 = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/main-art-list[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/img[2]");

    public static WebElement Get_listImg2() {
        return getElement(listImg2);
    }

    public static By listImg3 = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/main-art-list[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/img[3]");

    public static WebElement Get_listImg3() {
        return getElement(listImg3);
    }


}
