==========================
JavaLearningPath: Day1
==========================

Bu proje, Java programlama dili kullanılarak geliştirilmiş basit bir uygulamayı içermektedir. `day1` dizini, bu projeye ait kaynak kodları ve temel Java OOP (Nesne Yönelimli Programlama) kavramlarını içeren örnekleri barındırır.

Kurulum ve Çalıştırma
======================

1. Depoyu Klonlayın:
---------------------
Projeyi GitHub üzerinden klonlayın:

.. code-block:: bash

    git clone https://github.com/emrekndl/JavaLearningPath.git
    cd JavaLearningPath/day1

2. Derleme
-----------
Projeyi derlemek için önce bir `bin` dizini oluşturun ve kaynak kodları derleyin:

.. code-block:: bash

    mkdir bin
    javac -d bin src/*.java

Bu komut, `src/` klasöründeki tüm `.java` dosyalarını derler ve derlenmiş `.class` dosyalarını `bin` klasörüne yerleştirir.

3. Çalıştırma
--------------
Derlenen projeyi çalıştırmak için şu komutu kullanın:

.. code-block:: bash

    java -cp bin Main

Bu komut, `Main` sınıfındaki `main` metodunu çalıştırır.

Dizin Yapısı
==================

Proje dizini şu şekilde organize edilmiştir:

.. code-block::

    day1/
    ├── src/
    │   ├── AutoLoanManager.java
    │   ├── BaseDatabaseManager.java
    │   ├── ...
    │   └── WomanGameCalculate.java
    └── bin/
        └── (Derlenmiş .class dosyaları)

OOP (Nesne Yönelimli Programlama) Kavramları
============================================

Bu proje, Java'daki temel nesne yönelimli programlama (OOP) kavramlarını içeren örnekler sunar. Aşağıda her bir kavram hakkında kısa bir açıklama ve projede nasıl uygulandıkları belirtilmiştir.

1. Kapsülleme (Encapsulation)
-----------------------------
Kapsülleme, bir sınıfın verilerini dış dünyadan gizler ve bu verilere sadece kontrollü bir şekilde erişim sağlar. Projede, her sınıfın alanları (verileri) özel (`private`) olarak tanımlanmış ve bu alanlara erişim get/set metotları ile sağlanmıştır.

Örnek: `Customer.java` sınıfı.

2. Kalıtım (Inheritance)
------------------------
Kalıtım, bir sınıfın başka bir sınıftan özellik ve davranışları devralmasını sağlar. Projede, çeşitli sınıflar birbirinden türetilmiştir, böylece ortak davranışlar tekrar kullanılabilir hale gelmiştir.

Örnek: `BaseLoanManager.java` sınıfından türetilen `AutoLoanManager.java`, `MortgageLoanManager.java` gibi sınıflar.

3. Çok Biçimlilik (Polymorphism)
--------------------------------
Çok biçimlilik, nesnelerin farklı şekillerde davranabilmesini sağlar. Projede, bir sınıfın farklı alt sınıfları, aynı arayüz veya üst sınıf üzerinden farklı şekilde davranabilir.

Örnek: `LoanUI.java` sınıfı, farklı kredi yönetimi sınıfları ile çalışabilir (`AutoLoanManager`, `MortgageLoanManager` vs.).

4. Soyutlama (Abstraction)
--------------------------
Soyutlama, detayları gizleyip sadece önemli özellikleri gösterme yeteneğidir. Projede soyut sınıflar ve metotlar kullanılmıştır, böylece belirli bir işlevsellik alt sınıflar tarafından gerçekleştirilir.

Örnek: `BaseLoanManager.java` soyut sınıfı, farklı kredi yönetimlerinin temel işlevselliğini sağlar.

5. Arayüzler (Interface)
------------------------
Arayüzler, bir sınıfın gerçekleştirmesi gereken metotların bir şablonunu sağlar. Projede, arayüzler belirli bir işlevin nasıl yapılacağını belirleyen sınıfları bir araya getirir.

Örnek: `ICustomerDal.java` ve `IRepository.java` arayüzleri.

