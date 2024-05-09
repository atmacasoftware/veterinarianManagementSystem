package net.atmacacode.veterinarian.core.utilies;


public class Msg {
    public static final String CREATED = "Kayıt eklendi";
    public static final String OK = "İşlem başarılı";
    public static final String VALIDATE_ERROR = "Veri doğrulama hatası";
    public static final String NOT_FOUND = "Veri bulunamadı";
    public static final String IS_EXIST = "İlgili kayıt sistemde zaten kayıtlıdır.";

    public static <T> String notFound(T data) {
        return data + " verisi bulunamadı.";
    }

    public static String IsExistEmail(String email) {
        return email + " sistemde zaten kayıtlıdır.";
    }

}
