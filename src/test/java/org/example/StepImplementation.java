package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import driver.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Request.MkkRequest;
import org.example.Response.MkkResponse;
import org.openqa.selenium.*;

import java.io.*;

import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;


public class StepImplementation {

    WebDriver driver;
    Actions actions;
    List<MkkResponse> mkkResponses = null;
    MkkRequest mkkRequest = new MkkRequest();
    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    private Map<String, By> elementSelectors;
    private String degisenBaslangicTarihi;
    private String degisenBitisTarihi;
    String jsonBody = "";


    public StepImplementation() {
        driver = Base.driver;
        this.actions = new Actions(driver);
        elementSelectors = new HashMap<>();
        elementSelectors.put("hoverBildirimSorgulari", By.cssSelector("a[id='menu0']"));
        elementSelectors.put("detayliSorguEkrani", By.cssSelector("a[href='/tr/bildirim-sorgu']"));
        elementSelectors.put("tarihSecimi", By.cssSelector("input[id='memberDateRange']"));
        elementSelectors.put("endeksSecimi", By.cssSelector("div[selected-item='memberVm.options.indices.code']"));
        elementSelectors.put("bistBilisimEndeksi", By.cssSelector("a[code='33E5FED8024000EAE0530A4A622B2AEA']"));
        elementSelectors.put("bildirimFiltresi", By.xpath("(//span[@class='multiSelect inlineBlock'])[3]/button"));
        elementSelectors.put("finansalBildirim",By.xpath("(//div[@class='checkBoxContainer'])[3]/descendant::span[3]"));
        elementSelectors.put("oncekiAyaIlerle", By.xpath("//th[@class='prev available']"));
        elementSelectors.put("sonrakiAyaIlerle", By.xpath("//th[@class='next available']"));
        elementSelectors.put("ilkSecilenGun", By.xpath("(//td[@class='available'])[last()]"));
        elementSelectors.put("sonSecilenGun", By.xpath("(//td[@class='available'])[last()]"));
        elementSelectors.put("buttonUygula", By.xpath("//div[@class='range_inputs']/button[1]"));
        elementSelectors.put("buttonAra", By.xpath("(//a[@class='filter-button4 first'])[1]"));
        elementSelectors.put("baslangicTarihi", By.xpath("//span[@ng-show='(memberVm.options.date.startDate)']"));
        elementSelectors.put("bitisTarihi", By.xpath("//span[@ng-show='(memberVm.options.date.endDate)']"));
    }

    @Step("<url> adresine gidilir")
    public void gotoUrl(String url) {
        try {
            driver.get(url);
            System.out.println(url + "adresine gidiliyor.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Step("<key> elementin üstünde bekle")
    public void hoverElement(String key) {
        By by = elementSelectors.get(key);
        WebElement webElement = driver.findElement(by);
        actions.moveToElement(webElement).build().perform();
        Logger.info(key + " elementin üstünde beklendi.");

    }

    @Step("<key> elementine tıkla")
    public void clickElement(String key) {
        By by = elementSelectors.get(key);
        driver.findElement(by).click();
        waitBySeconds(2);
        Logger.info(key + " elementine tıklandı");
    }

    @Step({"<key> alanina js ile kaydir"})
    public void scrollToElementWithJs(String key) {
        By by = elementSelectors.get(key);
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    @Step({"<int> saniye bekle"})
    public void waitBySeconds(int seconds) {
        try {
            Logger.info(seconds + " saniye bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            Logger.info(e.getMessage());
        }
    }

    @Step("Bugünün tarihini al ve 3 aylık ay kapanışa göre seçim yap")
    public void currentDate() {
        LocalDate today = LocalDate.now();
        YearMonth suankiAyYil = YearMonth.from(today);
        LocalDate suankiAyinSonGunu = suankiAyYil.atEndOfMonth();
        if (!suankiAyinSonGunu.equals(today)) {
            Logger.info("Bugün ayın son gününde değil, bu aydan önceki 3 ayın kapanışını seçilecek.");
            for (int i = 0; i < 5; i++) {
                clickElement("oncekiAyaIlerle");
            }
            clickElement("ilkSecilenGun");
            for (int i = 0; i < 3; i++) {
                clickElement("sonrakiAyaIlerle");
            }
            clickElement("sonSecilenGun");
            clickElement("buttonUygula");
            waitBySeconds(4);
        } else {
            Logger.info("Bugün ayın son günü, bu ayda dahil 3 ayın kapanışını seçilecek.");
            for (int i = 0; i < 3; i++) {
                clickElement("oncekiAyaIlerle");
            }
            clickElement("ilkSecilenGun");
            for (int i = 0; i < 2; i++) {
                clickElement("sonrakiAyaIlerle");
            }
            clickElement("sonSecilenGun");
            clickElement("buttonUygula");
            waitBySeconds(2);
        }
    }

    @Step("<key>,<key2> Elementin text değerini al, ardından yyyy-mm-dd formatına uygun olarak yaz")
    public void printElementText(String key, String key2) {
        String baslangicTarihi = getElementText(key);
        String degisenBaslangicTarihi = convertDateFormat(baslangicTarihi, "Başlangıç Tarihi: ");
        System.out.println(degisenBaslangicTarihi);

        String bitisTarihi = getElementText(key2);
        String degisenBitisTarihi = convertDateFormat(bitisTarihi, "Bitiş Tarihi: ");
        System.out.println(degisenBitisTarihi);
    }

    private String getElementText(String key) {
        By by = elementSelectors.get(key);
        WebElement keyElement = driver.findElement(by);
        return keyElement.getText().trim();
    }

    private String convertDateFormat(String date, String hangiTarih) {
        String regex = hangiTarih + "(\\d{2})-(\\d{2})-(\\d{4})";
        String degisenTarih = date.replaceAll(regex, "$3-$2-$1").trim();
        if (hangiTarih.equals("Başlangıç Tarihi: ")) {
            this.degisenBaslangicTarihi = degisenTarih;
        } else if (hangiTarih.equals("Bitiş Tarihi: ")) {
            this.degisenBitisTarihi = degisenTarih;
        }
        return degisenTarih;
    }

    private void requestBodySet(){
        mkkRequest.setFromDate(degisenBaslangicTarihi);
        mkkRequest.setToDate(degisenBitisTarihi);
        mkkRequest.setYear("");
        mkkRequest.setPrd("");
        mkkRequest.setTerm("");
        mkkRequest.setRuleType("");
        mkkRequest.setBdkReview("");
        mkkRequest.setDisclosureClass("FR");
        mkkRequest.setIndex("33E5FED8024000EAE0530A4A622B2AEA");
        mkkRequest.setMarket("");
        mkkRequest.setIsLate("");
        mkkRequest.setSubjectList(new ArrayList<>());
        mkkRequest.setMkkMemberOidList(new ArrayList<>());
        mkkRequest.setInactiveMkkMemberOidList(new ArrayList<>());
        mkkRequest.setBdkMemberOidList(new ArrayList<>());
        mkkRequest.setMainSector("");
        mkkRequest.setSector("");
        mkkRequest.setSubSector("");
        mkkRequest.setMemberType("IGS");
        mkkRequest.setFromSrc("N");
        mkkRequest.setSrcCategory("");
        mkkRequest.setDiscIndex(new ArrayList<>());

        try {
            jsonBody = objectMapper.writeValueAsString(mkkRequest);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    private void sortedResponse(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Host", "www.kap.org.tr");
        request.header("Accept", "*/*");
        request.header("Accept-Encoding", "gzip, deflate, br");
        request.header("Cookie", "KAP=AAU7RgF4ZJtpESgAAAAAADsUL9ZOBg_0wi2-O8TBNPmu2pvA4Su5CZ-1pHShUHLOw==ywR4Zg==m1y2CZ0u6TEnD5i9rGACnA==; _ga=GA1.1.1172030342.1718110100; _ga_MBNFVK7SX4=GS1.1.1718996784.9.1.1718997061.60.0.0;");
        request.header("Connection", "keep-alive");
        request.body(jsonBody);
        response = request.post("https://www.kap.org.tr/tr/api/memberDisclosureQuery");

        if (response.getStatusCode() != 200) {
            System.out.println("status code yanlış.");
        } else {
            try {
                eskiDosyalariSil();
                String jsonResponse = response.getBody().asString();
                mkkResponses = objectMapper.readValue(jsonResponse, new TypeReference<List<MkkResponse>>() {});

                siralaVeDosyayaYaz(mkkResponses, "siralanmis_response/sirket_ismine_gore_siralanmis.txt", Comparator.comparing(MkkResponse::getKapTitle));
                siralaVeDosyayaYaz(mkkResponses, "siralanmis_response/tarihe_gore_siralanmis.txt", Comparator.comparing(MkkResponse::getPublishDate).reversed());
                siralaVeDosyayaYaz(mkkResponses, "siralanmis_response/artan_endekse_gore_siralanmis.txt", Comparator.comparingInt(MkkResponse::getDisclosureIndex).reversed());


            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    private static void dosyayaYaz(String dosyaAdi, List<MkkResponse> responses) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for (MkkResponse response : responses) {
                writer.write(response.toString());
                writer.newLine();
            }
        }
    }
    private static void siralaVeDosyayaYaz(List<MkkResponse> responses, String dosyaAdi, Comparator<MkkResponse> comparator) throws IOException {
        Collections.sort(responses, comparator);
        dosyayaYaz(dosyaAdi, responses);
    }

    @Step("Filtrelere göre arama sonucunun requestBody'sine get isteği at, dönen response sonuçlarını kaydet")
    public void getService() {
        requestBodySet();
        sortedResponse();
    }

    @Step("Response sorgusundan dönen verilerin sayfa üzerinde varlığını kontrol et")
    public void checkResponse(){
        List<String> varOlanKapTitle = new ArrayList<>();
        int i=1;
        for (MkkResponse response1: mkkResponses){
            String kapTitle = response1.getKapTitle().toString();
            if (!varOlanKapTitle.contains(kapTitle)) {
                varOlanKapTitle.add(kapTitle);
                System.out.println(i+"." + kapTitle);
                i++;
                String sayfaUzerindekiKapTitle = "//*[contains(text(),'" + kapTitle + "')]";
                driverFindElements(sayfaUzerindekiKapTitle, kapTitle);
            }

        }
    }
    private void driverFindElements(String key, String kapTitle) {
        List<WebElement> elements = driver.findElements(By.xpath(key));
        if (!elements.isEmpty()) {
            System.out.println("Sayfa üzerinde bulunan kapTitle: " + kapTitle);
        } else {
            System.out.println("Sayfa üzerinde bulunmayan kaptTitle: " + kapTitle);
        }
    }

    private static void eskiDosyalariSil() {
        File dir = new File("siralanmis_response");
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        } else {
            dir.mkdirs();
        }
    }
}






