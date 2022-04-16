import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Main {


  public static void main(String[] args) throws IOException {
    File f = new File("contact.vcf");
    FileOutputStream fop = new FileOutputStream(f);

    String photoBase64String = getImageAsStringInCorrectFormat(encodeFileToBase64Binary());
    String str = "BEGIN:VCARD\n" +
        "VERSION:4.0\n" +
        "N:Todorova;Elisaveta;;;\n" +
        "FN:Elisaveta Todorova\n" +
        "ORG:Sofia University, Bulgaria;Software Technologies\n" +
        "TITLE:soft.eng., student\n" +
        "TEL;TYPE=work,voice;VALUE=uri:0812345678\n" +
        "EMAIL:elisaveta.p.todorova@gmail.com\n" +
        "ADR;WORK;PREF;ENCODING=QUOTED-PRINTABLE:;;Student city, =0D=0A=" + "\n" +
        "Sofia, Bulgaria;;;Bulgaria" + "\n" +
        "PHOTO;TYPE=JPEG;ENCODING=BASE64:\n" +
        photoBase64String + "\n" +
        "X-MS-OL-DESIGN;CHARSET=utf-8:<card xmlns=\"http://schemas.microsoft.com/office/outlook/12/electronicbusinesscards\" ver=\"1.0\" layout=\"left\" bgcolor=\"ffffff\"><img xmlns=\"\" align=\"tleft\" area=\"32\" use=\"photo\"/><fld xmlns=\"\" prop=\"name\" align=\"left\" dir=\"ltr\" style=\"b\" color=\"000000\" size=\"10\"/><fld xmlns=\"\" prop=\"org\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"title\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"dept\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"email\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"email2\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"addrwork\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"webwork\" align=\"left\" dir=\"ltr\" color=\"000000\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/><fld xmlns=\"\" prop=\"blank\" size=\"8\"/></card>\n" +
        "REV:20080424T195243Z\n" +
        "END:VCARD";
    fop.write(str.getBytes());
  }

  private static String encodeFileToBase64Binary() {
    File file = new File("eli.JPG");
    String encodedfile = null;
    try {
      FileInputStream fileInputStreamReader = new FileInputStream(file);
      byte[] bytes = new byte[(int) file.length()];
      fileInputStreamReader.read(bytes);
      encodedfile = new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return encodedfile;
  }

  private static String getImageAsStringInCorrectFormat(String image) {
    StringBuilder result = new StringBuilder();
    result.append(" ");
    for (int i = 1; i < image.length(); i++) {

      result.append(image.charAt(i - 1));

      if (i % 72 == 0) {
        result.append("\n ");
      }
    }

    return result.toString();
  }
}

