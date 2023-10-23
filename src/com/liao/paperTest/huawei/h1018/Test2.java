package com.liao.paperTest.huawei.h1018;

/**
 * @author liaoguixin
 * @date 2023/10/18
 */
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Package {
    LocalDate arrivalDate;
    String phoneNumber;
    public Package(LocalDate date, String phone) {
        this.arrivalDate = date;
        this.phoneNumber = phone;
    }
}

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        HashMap<String, List<Package>> packs = new HashMap<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split(" ");
            LocalDate date = LocalDate.parse(tokens[0], fmt);
            for (int j = 1; j < tokens.length; j++) {
                String pn = tokens[j];
                packs.putIfAbsent(pn, new ArrayList<>());
                packs.get(pn).add(new Package(date, pn));
            }
        }
        String[] tokens = sc.nextLine().split(" ");
        LocalDate cData = LocalDate.parse(tokens[0], fmt);
        String cPhone = tokens[1];
        int tp = 0;
        int fees = 0;
        List<Package> cPacks = packs.get(cPhone);
        if (cPacks != null) {
            for (Package p : cPacks) {
                tp++;
                long days = p.arrivalDate.until(cData).getDays();
                if (days > 3) {
                    fees += (days - 3);
                }
            }
        }
        System.out.println(tp + " " + fees);
    }
}
