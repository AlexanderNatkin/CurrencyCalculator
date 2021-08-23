package currencyCalculator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

        /* парсер для сбора информации об актуальных курсах валют
        считывается XML файл с сайта ЦБ, распарсивается и вынимается курс той валюты,
        буквенный код которой мы передаем в метод
        */

public class Parser {

    private static final String TAG_CODE = "CharCode";
    private static final String TAG_VALUE = "Value";

    public double getCurrencyRate(String currencyCode) throws Exception {

        // объявляем переменную для актуального курса валюты
        double currencyRate = 0.0;

        // открываем XML с сайта ЦБ
        URL url = new URL("https://www.cbr.ru/scripts/XML_daily.asp");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = dbf.newDocumentBuilder().parse(String.valueOf(url));

        // получаем основной элемент файла (в нашем случае ValCurs)
        Node valCursNode = doc.getFirstChild();

        // получаем список вложенных элементов (в нашем случае Valute)
        NodeList valCursChild = valCursNode.getChildNodes();
        for (int i = 0; i < valCursChild.getLength(); i++) {
            String code = "";
            String value = "";

            // заходим в каждый блок Valute и записываем значения соответствующих элементов в переменные code и value
            NodeList valuteChild = valCursChild.item(i).getChildNodes();
            for (int j = 0; j < valuteChild.getLength(); j++) {
                switch (valuteChild.item(j).getNodeName()) {
                    case TAG_CODE -> code = valuteChild.item(j).getTextContent();
                    case TAG_VALUE -> value = valuteChild.item(j).getTextContent();
                }
            }
            // получаем курс валюты, преобразовав String в double, заменив разделитель на точку
            if (code.equals(currencyCode)) {
                currencyRate = Double.parseDouble(value.replace(",", "."));
            }
        }
        return currencyRate;
    }
}