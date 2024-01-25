# E Commerce Clone(Backend)

```
- Kullanıcı, Ürün ve yorumları yöneten bir servistir.
- Bir bir e-maili ve bir telefon numarası sadece bir kullanıcıya ait olabilir.
- Aynı kullanıcı adı, telefon ya da e-mail ile kayıt yapılamaz.
- Kullanıcı tipi kişi ya da kurum olabilir.

Product Controller:
Ürün kaydeden bir servis
Ürünleri listeleyebilen bir servis 
Ürün idsinden ürünü bulan bir servis 
Ürün silen bir metot 
Ürün fiyatı güncelleyen bir metot  (Sadece fiyat)

User controller:
Tüm kullanıcıları getiren bir servis 
Kullanıcı idsinden kullanıcıyı getiren bir servis 
Kullanıcı adından kullanıcıyı getiren bir servis 
Kullanıcı kaydedilebilecek bir servis 
Kullanıcı silebilecek bir servis (kullanıcı adı, ve telefon bilgileri alınıyor). Eğer kullanıcı
adı ve telefon uyuşmuyorsa “XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.”
şeklinde bir uyarı veriyor
Kullanıcı bilgilerini güncelleyebilecek bir servis

Comment Controller
Bir kullanıcının yaptığı yorumlari getiren bir servis. Eğer ilgili kullanıcının henüz bir
yorumu yoksa “XXX kullanıcı henüz bir yorum yazmamıştır” şeklinde bir hata veriyor
Bir ürüne yapılan tüm yorumları getiren bir servis. Eğer o ürüne henüz bir yorum
yazılmamışsa “XXX ürüne henüz bir yorum yazılmamıştır” şeklinde bir hata.
Yeni bir yorum yazılabilecek bir servis
Yorum silebilecek bir servis

```

## Kullanılan Teknolojiler ve IDE
* Maven
* Spring Boot
  * Spring Web
  * Spring Boot DevTools
  * Spring Data JPA
  * MapStruct
  * Swagger
  * Lombok
* PostgreSQL
* IntelliJ IDEA

## Kurulum ve Çalıştırma
```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/ecom
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.properties.javax.persistence.validation.mode = none

spring.main.allow-circular-references=true
```

# API Definitions
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/27425c96-aaa6-4a38-aa3f-a5b056e03527)
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/df7493ff-b534-49c2-8a20-8a34ec479056)

#DTO Schemas
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/a36b536d-72bf-4896-8832-5c670e927afd)
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/d1bc4a05-899c-4dae-b34a-0583d05bee49)
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/c8f6017f-b4e7-4a26-97fd-a9fad05d30d2)
![image](https://github.com/iumutdikbasan/ecommerce/assets/54438200/89d5faa9-d216-4098-968e-ce09d0e7a13b)



