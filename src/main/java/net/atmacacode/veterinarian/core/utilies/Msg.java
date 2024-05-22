package net.atmacacode.veterinarian.core.utilies;


public class Msg {
    public static final String CREATED = "Kayıt eklendi";
    public static final String OK = "İşlem başarılı";
    public static final String VALIDATE_ERROR = "Veri doğrulama hatası";
    public static final String NOT_FOUND = "Veri bulunamadı";
    public static final String IS_EXIST = "İlgili işlem sistemde zaten kayıtlıdır.";

    public static <T> String notFound(T data, String name) {
        return data + " numaralı " + name + "bulunamadı.";
    }

    public static String IsExistEmail(String email) {
        return email + " sistemde zaten kayıtlıdır.";
    }

    public static String IsPossibilityRegistration(String name){
        return "Bu " + name + " daha önce sisteme kayıt edilmiş olabilir!";
    }

}
