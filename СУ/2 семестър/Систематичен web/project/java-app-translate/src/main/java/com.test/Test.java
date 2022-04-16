package com.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) throws IOException, InterruptedException {
//    writeEndResult();
    readFromFile();
//    Arrays.asList("), Izvorovo, Izvorovo, Izgrev (District Sliven), Izgrev, Izgrev (District Smolyan), Irnik, Iskar (District Pleven), Kazimir, Kalina, Kaloyan, Kamen, Kamen (District Sliven), Kamenets, Kamenitza, Kamenovo (District Sliven) ), Karavelovo, Kesten, Kirilovo (District Stara Zagora), Kiten, Kliment (District Plovdiv), Klashka Reka, Kovach (District Stara Zagora), Koevtsi, Kozarevets, Kozitsa, Kozyak, Komarevo (District Varna), Komarevo (District Vratsa) , Konare, Konevo, Konush, Konyovo, Kraina (Nedelino Municipality), Kraina, Krasen, Crete, Crete (Pleven District), Krumovo, Krumovo (Yambol District), Krushevo, Krushovitsa (Pleven District), Krushovitsa, Kupen, Kapinovo, Levski , Leska, Lipnitsa, Leaf, Hunter (District Targovishte), Hunter (District Shoumen), Lozen, Lozitsa, Laka, Lyuben, Lyubenovo, Lyubenovo (District Stara Zagora), Lyulin (District Yambol), Malomir (District Shoumen), Malchovtsi Veliko Tarnovo District), Monastery (Plovdiv District), Markovo, Markovo (Shoumen District), Matsa, Metlichina, Metodievo (Shoumen District), Miladinovtsi, Miladinovtsi (Yambol District), Milanovo, Mirovo, Mihailovo, Mihalich, Mogila (Yambol District) , Mokresh, Morava, Mor avica, Marble (Pernik District), Murgash, Musachevo (Stara Zagora District), Madrets, Naum, Neykovo, Nikolaevo, Nikolaevo (Pernik District), Nikolaevo (Pleven District), Nikolaevo (Sliven District), Nikolovo, Nikolchovtsi (Veliko Tarnovo District) ), Oborishte, Aries, Oman, Omarchevo (Shoumen District), Oreshene, Oreshets (Smolyan District), Orlovo, Oselna (Sofia District), Oselna, Osen (Silistra District), Osen (Vratsa District), Ostrets, Ostritsa, Ostritsa Smolyan District), Padina, Paisii, Panayot Hitovo, Pevets, Parvenets, Pesnopoy, Pet Mogili, Pet Mogili, Petrov Dol, Petrov Dol (Smolyan District), Petrovo, Peshtera (Smolyan District), Pisarevo (Shoumen District), Planintsi (District Smolyan), Pobeda (Yambol District), Pobit Kamak, Shelter, Pozharevo, Polyana (Smolyan District), Polyana, Popovo, Popovtsi (Veliko Tarnovo District), Popovtsi, Popska (Veliko Tarnovo District), Poroyno, Poroyno (Targovishte District), Sowing, Flood, Pravda, Pravda (Silistra District), Presian, Prodanovtsi (Veliko Tarnovo District), Prolom, Pryaporets, Ravna, Ravna (Sofia District), Ravno Selo, Radevo, Radovtsi (Veliko Tarnovo District), Section listra), Raynovtsi (Veliko Tarnovo District), Rakitnitsa, Rakitnitsa, Ralitsa (Targovishte District), Rayanovtsi, Rebro, Ribaritsa, Ribnitsa, Rodina, Rozovo (Pazardzhik District), Rosen, Rositsa (Targovishte District), Rudnik, Ruen, Ruzhitsa ( Yambol District), Ruzhitsa, Ruptsi, Ruptsi (Pleven District), Sava, Savin, Svetlya, Svoboda, Selce, Selyanin, Septemvriytsi, Skobelevo, Skobelevo, Slaveykovo, Slaveykovo (Yambol District), Slavyanin, Slatina, Slatino, Slivovitsa, Slimi Spasovo, Sredets (District Stara Zagora), Sredno Selo, Sredno selo (District Veliko Tarnovo), Sredorek, Stambolovo, Stambolovo (District Ruse), Stanyantsi (District Shoumen), Stanyovtsi, Stara reka (District Yambol), Stara Reka, Staro Selo , Stefan Karadja, Stefan Karadja (Silistra District), Stoletovo, Stoletovo (Stara Zagora District), Stoyanovtsi (Veliko Tarnovo District), Strazha, Strazhets, Strandzha, Strashimir, Sagittarius, Sagittarius (Stara Zagora District), Streltsi, Streltsi ), Strupets, Stryama, Studena, Studenitsa, Suha Reka, Suhodol, Saedinenie (Targovishte District), Sarnevo, Sarnino, Tatarevo, Tervel, Ticha, Todorovtsi (Veliko Tarnovo District), Tra ve, Thrace, Tri Mogili, Troyanovo (Stara Zagora District), Trunkovo \u200B\u200B(Yambol District), Trunkovo, Tarnava, Tarnovtsi, Factory, Hadjidimitrovo (Stara Zagora District), Hrabrovo, Hristovtsi (Veliko Tarnovo District), Huma, Harsovo (Shoumen District) ), Tsar Asen, Tsar Asen (Targovishte District), Tsarevets (Vratsa District), Tsarevtsi, Tsvetnitsa, Chavdartsi (Veliko Tarnovo District), Chaika, Chepino, Cherkovna, Cherkovna, Cherkovna, Cherkovna, Cherna Voda, Cherni Vrah, Chernozem, Cheshma , Chukovets, Shipkovitsa, Yantra, Yarebitsa, Yasen, Yasenovo, Temenuga (Veliko Tarnovo District), Razdelna, Matenitsa, Mechka (Pleven District), Lik, Kozarevets, Kalenik, Iglika (Yambol District), Zavoy, Dobrich, Vladislav, Ilinden, The town, Debelets, Dolna Vasilitsa, Neykyovets, Parvan, Q12140919, Prespa, Tseperanite, Cherkovishte, Varhari (Blagoevgrad district), Slivovo (Smolyan district), Stancha (Gabrovo district), Tamrash (village), Dolno Panicherevo, Vladovtsi, Vlasa , Bagpipes, Djurovtsi, Irinetsi, Karandili, Nyushkovtsi, Plazishte, Popovi Livadi, Brestovets, Q61021266, Banzareto".split(", "))
//    .forEach(System.out::println);
    
  }

  private static void callTranslationApi(String text) throws IOException, InterruptedException {

    HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString("q=" + text + "&target=en&source=bg");


    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
        .header("content-type", "application/x-www-form-urlencoded")
        .header("accept-encoding", "application/gzip")
        .header("x-rapidapi-key", "b95e5becc9msh534f7a0fc5888ebp17b662jsn4c8157d970cf")
        .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
        .method("POST", bodyPublisher)
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  }


  private static void readFromFile() throws IOException, InterruptedException {
    Pattern pattern = Pattern.compile("Q[0-9]+");


    String row = null;
    int count = 0;
    List<String> test = new ArrayList<>();
    String[] endRes = writeEndResult();
    try (BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/onlyNon.csv"));
         BufferedWriter csvWriter = new BufferedWriter(new FileWriter("src/main/resources/endResult.csv"));
    ) {


      while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        Matcher matcher = pattern.matcher(data[1]);

        if (matcher.find()) {

          csvWriter.append(data[0]);
          csvWriter.append(",");
          csvWriter.append(endRes[count]);
          csvWriter.append(",");
          csvWriter.append(data[2]);

          csvWriter.newLine();

          test.add(data[2]);
          count++;
        } else {
          System.out.println(data[1]);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    System.out.println(test.size());
    System.out.println(String.join(",", test));
    
    
    test.forEach(System.out::println);

    System.out.println();

  }


  private static String[] writeEndResult() {

    return "Blaskovo,Arkovna,Goren Chiflik,Kamen Dyal,Smirov Dol,Vidrar,Milkyovtsi,Banishte,Dolna Vrabcha,Dolni Romantsi,Belanitsa,Boboratsi,Dokyovtsi,Berende,Gorna Vrabcha,Vidritsa,Dolna Melna,Selishten Dol,Penkyovtsi,Gorni Romantsi,Novo Oryahovo,Dolna Lipnitsa,Belyakovets,Nova Shipka,Debeli rat,Gorni Tanchevtsi,Gorsko Kalugerovo,Tutrakantsi,Boychevi kolibi,Balgarsko Slivovo,Blaskovtsi,Bryagovitsa,Voynezha,Dolen Enevets,Gabrovtsi,Sladka Voda,Radan Voyvoda,Delova mahala,Badevtsi,Asenovo,Goren Enevets,Gorna Hadzhiyska,Ilakov Rat,Dalgi Pripek,Dolno Shivachevo,Dolni Tanchevtsi,Novo Gradishte,Krasno Gradishte,Dolni Maryan,Kisyovtsi,Dolni Damyanovtsi,Malki Chiflik,Mishemorkov Han,Ovcha Mogila,Cherni Dyal,Rusalya,General Marinovo,Dolni Boshnyak,Bela,Dinkovo,Brankovtsi,Botevo,Tsarski Izvor,Bela Rada,Mali Drenovets,Baurene,Golyamo Peshtene,Markovo Ravnishte,Cherno Pole,Gorna Beshovitsa,Mayor Uzunovo,Gorno Peshtene,Oslen Krivodol,Beli Izvor,Tsar Simeonovo,Bodenets,Tri Kladentsi,Sredni Rat,Malo Peshtene,Galovo,Dolni Vadin,Dolna Dabeva,Vidintsi,Aleksandrovo,Gorska Polyana,Palauzovo,Kostena Reka,Vasil Drumev,Zlatna Niva,Aleksandrovo,Zaychino Oreshe,Malko Sharkovo,Valcha Polyana,Blagovo,Byal Bryag,Golyam Dervent,Voynika,Drentsi,Konyovets,Zhrebino,Nova Byala Reka,Golyamo Krushevo,Mezhda,Dolno Varshilo,Gorna Dabeva,Malak Manastir,Malko Kirilovo,Dobri Voynikovo,Valchi Izvor,Roza,Irechekovo,Kapitan Petko,Varbak,Vodenichane,Krasen Dol,Gorna Birkova,Osenovets,Bashtino,Asenovets,Batsova Mahala,Batin,Banya,Begovo,Babuk,Aprilovo,Ahmatovo,Beli Bryag,Balyovtsi,Belitsa,Bogdanovo,Bistrentsi,Bogomilovo,Bivolare,Borislav,Borov Dol,Bozduganovo,Borisovo,Belyanovo,Bradvari,Bliznets,Valchan Dol,Vargov Dol,Varbnitsa,Varbitsa,Vetren,Visoka Polyana,Golyamo Dolyane,Gorna Arda,Golyama Voda,Glufishevo,Gergevets,Golyamo Chochoveni,Golyamo Vranovo,Gorna Zlatitsa,Golyam Porovets,Golyamo Tsarkvishte,Gorna Hubavka,Golyamo Dryanovo,Gorno Belevo,Dobreva Cheresha,Dolna Zlatitsa,Dolno Novkovo,Elyovo,Dolno Izvorovo,Dolna Hubavka,Dragash Voyvoda,Bikovo,Brestovitsa,Brakyovtsi,Botrov,Bardo,Bryastovo,Badeshte,Breste,Bardokva,Bukorovtsi,Bratya Kunchevi,Bukova Polyana,Velyovo,Vodenicharovo,Vrani Kon,Vidrare,Gaytanevo,Gorni Domlyan,Dolni Lukovit,Gorsko Selo,Dolno Kozarevo,Ekzarh Yosif,Gorno Ablanovo,Dlazhka Polyana,Dve Topoli,Dolni Vit,Gorno Kozarevo,Dolna Studena,Dolno Novo Selo,Gorno Botevo,Daskal-atanasovo,Gorno Novkovo,Zhelyu Voyvoda,Krushev Dol,Kozar Belenea,Zhalt Bryag,Isyovtsi,Zhalt Kamak,Zlati Voyvoda,Kulina Voda,Ivan Shishmanovo,Zlatovrah,Kara Mihal,Zelena Morava,Kyolmen,Malko Krushevo,Lyubenova Mahala,Malki Iskar,Malko Yonkovo,Lavino,Malko Vranovo,Lyubichevo,Malka Cherkovna,Malka Vereya,Malko Kadievo,Mala Rakovitsa,Malko Dryanovo,Lyaskovo,Malko Tranovo,Malko Chochoveni,Malo Krushevo,Malak Porovets,Manolovo,Manaselska Reka,Marino Pole,Medovene,Mechovo,Malak Dol,Novi Izvor,Polkovnik Cholakovo,Ploska Mogila,Ostri Pazlak,Momino Selo,Nayden Gerovo,Panayot-volovo,Podgoritsa,Nova Popina,Polsko Padarevo,Polsko Kosovo,Orach,Polkovnik Taslakovo,Polkovnik Lambrinovo,Pet Kladentsi,Osikovska Lakavitsa,Otets Kirilovo,Ostra Mogila,Riben Dol,Sini Vir,Sladak Kladenets,Staychin Dol,Stoil Voyvoda,Sredno Gradishte,Stara Rechka,Stoyan-zaimovo,Sadiysko Pole,Stoyan Mihaylovski,Nova Mahala,Razdeltsi,Profesor Ishirkovo,Ravno Pole,Ravno Nivishte,Staro Selishte,Todor Ikonomovo,Topolovets,Tanka Bara,Chervena Voda,Tsani Ginchevo,Han Asparuhovo,Tsarev Dol,Cherni Bryag,Yakim Gruevo,Borovo,Malka Arda,Benkovski,Gledachevo,Dolno Ablanovo,Golemanovo,Glavatsi,Izvor Mahala,Belashtitsa,Belokopitovo,Bozyova,Bozhurka,Bayachevo,Alvanovo,Golyamo Novo,Golyamo Sokolovo,Brest,Radko Dimitrievo,Sinya Voda,Tsar Shishmanovo,Tsar-petrovo,Butan,Q3563482,Valchovtsi,Asparuhovo,Boyana,Brezovo (Oblast Veliko Tarnovo),Bukovets (Oblast Vratsa),Bukovo (Oblast Smolyan),Bulair,Bazovets,Barzina,Byal Izvor,Byal Kladenets,Byala Voda,Byala Reka,Vasil Levski (Oblast Silistra),Vasil Levski (Oblast Targovishte),Velikdenche,Velikovo,Velichkovo,Velichkovo,Velkovtsi (Oblast Veliko Tarnovo),Venelin,Venets (Oblast Stara Zagora),Veselets,Veselets (Oblast Targovishte),Veselina (Oblast Veliko Tarnovo),Veselinovo (Oblast Yambol),Vinarovo,Viskyar,Visok,Vladimir,Voden,Voditsa,Vodno,Vodno (Oblast Silistra),Vodnyantsi,Vokil,Vabel,Vaglen,Varba,Varba (Oblast Smolyan),Varbovo (Oblast Smolyan),Varli Dol,Gabritsa,Garvan,General Kolevo,General Toshevo,Glavan,Glavanovtsi,Glashatay,Golyam izvor (Oblast Razgrad),Goranovtsi (Oblast Veliko Tarnovo),Gorovo,Gospodinovo (Oblast Silistra),Gradina,Gradishte,Gramade,Galabovo,Davidovo,Dvorishte,Delchevo,Dzhulyunitsa,Dzhulyunitsa (Oblast Ruse),Dimovtsi,Dimovtsi (Oblast Stara Zagora),Dobrevtsi (Oblast Veliko Tarnovo),Dobri Dol,Dobrotitsa (Oblast Targovishte),Doyrantsi,Dolets,Dolina,Draganovtsi (Oblast Veliko Tarnovo),Dragnevtsi (Oblast Veliko Tarnovo),Dragomirovo,Drangovo,Drandar,Dryanovets (Oblast Smolyan),Dryanovo (Oblast Plovdiv),Dryanovo,Dunavtsi (Oblast Veliko Tarnovo),Dunavtsi (Oblast Stara Zagora),Dabova,Dabova (Oblast Smolyan),Dabovo,Dalgo Pole,Dalgo pole (Oblast Plovdiv),Elovitsa,Elhovo,Zhivkovo,Zagore,Zagortsi,Zagrazhden,Zvezditsa,Zvanets,Zdravets,Zdravets (Oblast Razgrad),Zetyovo,Zimnitsa,Zlatina,Znamenosets,Ivanovtsi (Oblast Veliko Tarnovo),Iglika,Ignatovtsi (Oblast Veliko Tarnovo),Izvorovo,Izvorovo,Izgrev (Oblast Sliven),Izgrev,Izgrev (Oblast Smolyan),Irnik,Iskar (Oblast Pleven),Kazimir,Kalina,Kaloyan,Kamen,Kamen (Oblast Sliven),Kamenets,Kamenitsa,Kamenovo (Oblast Sliven),Karavelovo,Kesten,Kirilovo (Oblast Stara Zagora),Kiten,Kliment (Oblast Plovdiv),Klashka Reka,Kovach (Oblast Stara Zagora),Koevtsi,Kozarevets,Kozitsa,Kozyak,Komarevo (Oblast Varna),Komarevo (Oblast Vratsa),Konare,Konevo,Konush,Konyovo,Krayna (Obshtina Nedelino),Krayna,Krasen,Kreta,Kreta (Oblast Pleven),Krumovo,Krumovo (Oblast Yambol),Krushevo,Krushovitsa (Oblast Pleven),Krushovitsa,Kupen,Kapinovo,Levski,Leska,Lipnitsa,Listets,Lovets (Oblast Targovishte),Lovets (Oblast Shumen),Lozen,Lozitsa,Laka,Lyuben,Lyubenovo,Lyubenovo (Oblast Stara Zagora),Lyulin (Oblast Yambol),Malomir (Oblast Shumen),Malchovtsi (Oblast Veliko Tarnovo),Manastir (Oblast Plovdiv),Markovo,Markovo (Oblast Shumen),Matsa,Metlichina,Metodievo (Oblast Shumen),Miladinovtsi,Miladinovtsi (Oblast Yambol),Milanovo,Mirovo,Mihaylovo,Mihalich,Mogila (Oblast Yambol),Mokresh,Morava,Moravitsa,Mramor (Oblast Pernik),Murgash,Musachevo (Oblast Stara Zagora),Madrets,Naum,Neykovo,Nikolaevo,Nikolaevo (Oblast Pernik),Nikolaevo (Oblast Pleven),Nikolaevo (Oblast Sliven),Nikolovo,Nikolchovtsi (Oblast Veliko Tarnovo),Oborishte,Oven,Oman,Omarchevo (Oblast Shumen),Oreshene,Oreshets (Oblast Smolyan),Orlovo,Oselna (Sofiyska oblast),Oselna,Osen (Oblast Silistra),Osen (Oblast Vratsa),Ostrets,Ostritsa,Ostritsa (Oblast Smolyan),Padina,Paisiy,Panayot Hitovo,Pevets,Parvenets,Pesnopoy,Pet Mogili,Pet Mogili,Petrov Dol,Petrov dol (Oblast Smolyan),Petrovo,Peshtera (Oblast Smolyan),Pisarevo (Oblast Shumen),Planintsi (Oblast Smolyan),Pobeda (Oblast Yambol),Pobit Kamak,Podslon,Pozharevo,Polyana (Oblast Smolyan),Polyana,Popovo,Popovtsi (Oblast Veliko Tarnovo),Popovtsi,Popska (Oblast Veliko Tarnovo),Poroyno,Poroyno (Oblast Targovishte),Posev,Potop,Pravda,Pravda (Oblast Silistra),Presiyan,Prodanovtsi (Oblast Veliko Tarnovo),Prolom,Pryaporets,Ravna,Ravna (Sofiyska oblast),Ravno Selo,Radevo,Radovtsi (Oblast Veliko Tarnovo),Razdel (Oblast Silistra),Raynovtsi (Oblast Veliko Tarnovo),Rakitnitsa,Rakitnitsa,Ralitsa (Oblast Targovishte),Rayanovtsi,Rebro,Ribaritsa,Ribnitsa,Rodina,Rozovo (Oblast Pazardzhik),Rosen,Rositsa (Oblast Targovishte),Rudnik,Ruen,Ruzhitsa (Oblast Yambol),Ruzhitsa,Ruptsi,Ruptsi (Oblast Pleven),Sava,Savin,Svetlya,Svoboda,Seltse,Selyanin,Septemvriytsi,Skobelevo,Skobelevo,Slaveykovo,Slaveykovo (Oblast Yambol),Slavyanin,Slatina,Slatino,Slivovitsa,Smilets,Spasovo,Sredets (Oblast Stara Zagora),Sredno Selo,Sredno selo (Oblast Veliko Tarnovo),Sredorek,Stambolovo,Stambolovo (Oblast Ruse),Stanyantsi (Oblast Shumen),Stanyovtsi,Stara reka (Oblast Yambol),Stara Reka,Staro Selo,Stefan Karadzha,Stefan Karadzha (Oblast Silistra),Stoletovo,Stoletovo (Oblast Stara Zagora),Stoyanovtsi (Oblast Veliko Tarnovo),Strazha,Strazhets,Strandzha,Strashimir,Strelets,Strelets (Oblast Stara Zagora),Streltsi,Streltsi (Oblast Sliven),Strupets,Stryama,Studena,Studenitsa,Suha Reka,Suhodol,Saedinenie (Oblast Targovishte),Sarnevo,Sarnino,Tatarevo,Tervel,Ticha,Todorovtsi (Oblast Veliko Tarnovo),Trave,Trakiya,Tri Mogili,Troyanovo (Oblast Stara Zagora),Trankovo (Oblast Yambol),Trankovo,Tarnava,Tarnovtsi,Fabrika,Hadzhidimitrovo (Oblast Stara Zagora),Hrabrovo,Hristovtsi (Oblast Veliko Tarnovo),Huma,Harsovo (Oblast Shumen),Tsar Asen,Tsar Asen (Oblast Targovishte),Tsarevets (Oblast Vratsa),Tsarevtsi,Tsvetnitsa,Chavdartsi (Oblast Veliko Tarnovo),Chayka,Chepino,Cherkovna,Cherkovna,Cherkovna,Cherkovna,Cherna Voda,Cherni Vrah,Chernozem,Cheshma,Chukovets,Shipkovitsa,Yantra,Yarebitsa,Yasen,Yasenovo,Temenuga (Oblast Veliko Tarnovo),Razdelna,Matenitsa,Mechka (Oblast Pleven),Lik,Kozarevets,Kalenik,Iglika (Oblast Yambol),Zavoy,Dobrich,Vladislav,Ilinden,Gradat,Debelets,Dolna Vasilitsa,Neykyovets,Parvan,Q12140919,Prespa,Tseperanite,Cherkovishte,Varhari (Oblast Blagoevgrad),Slivovo (oblast Smolyan),Stancha (Oblast Gabrovo),Tamrash (selo),Dolno Panicherevo,Vladovtsi,Vlasatili,Valkovtsi,Gaydari,Dzhurovtsi,Irinetsi,Karandili,Nyushkovtsi,Plazishte,Popovi livadi,Brestovets,Q61021266,Banzareto".split(",");

  }
}
