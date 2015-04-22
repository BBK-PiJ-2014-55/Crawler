package Crawler;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by karolsudol on 22/04/15.
 */
public class Crawler {




    public static void main(String[] args) {

        ArrayList listOferrors = new ArrayList();

        String errorNourl = "no url found";
        String errorWrongUrl = "invalid url";

        String intro = "Please enter url";
        System.out.println(intro);
        Scanner in = new Scanner(System.in);
        String startUrl = in.nextLine().trim();

        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        if (startUrl.length() < 1) {
            listOferrors.add(errorNourl);
        } else if (!urlValidator.isValid(startUrl)){
            listOferrors.add(errorNourl);
        }

        String maxUrl =



    }






}
