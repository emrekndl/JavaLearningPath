Spring Cloud Stream ile Event-Driven Uygulama
===============================================

Bu proje, Spring Cloud Stream kullanarak RabbitMQ ile entegre bir şekilde çalışan üç uygulama içerir: `name-source`, `name-processor`, ve `name-sink`. Bu uygulamalar, event-driven bir yapıda veri akışını sağlar.

Proje Bileşenleri
==================

1. **name-source**: Bir String (isim) üreterek bu ismi event olarak yayınlar.

   - **Fonksiyon**: `Supplier<String>`
   - **Çıkış Binding**: `supplyName-out-0 = processorinput`

2. **name-processor**: Kaynaktan gelen String verisini alır, işleyerek bir `Person` nesnesine çevirir ve bu nesneye bir zaman damgası ekler.

   - **Fonksiyon**: `Function<String, Person>`
   - **Giriş Binding**: `processName-in-0 = processorinput`
   - **Çıkış Binding**: `processName-out-0 = sinkinput`

3. **name-sink**: Processor'dan gelen `Person` nesnesini tüketir ve konsola basar.

   - **Fonksiyon**: `Consumer<Person>`
   - **Giriş Binding**: `nameSink-in-0 = sinkinput`

Kullanım
========

1. RabbitMQ'yu Docker üzerinden başlatmak için `docker-compose.yml` dosyası kullanabilirsiniz:

   .. code-block:: yaml

       version: '3.8'

       services:
         rabbitmq:
           image: rabbitmq:3-management
           hostname: my-rabbit
           ports:
             - "15672:15672"  # RabbitMQ Management UI
             - "5672:5672"    # RabbitMQ default port

2. Daha sonra aşağıdaki komut ile başlatın:

   .. code-block:: bash

       docker-compose up -d

RabbitMQ Dashboard'a (http://localhost:15672) erişmek için `guest` kullanıcı adı ve `guest` şifresi ile giriş yapabilirsiniz.


Uygulamaları sırasıyla çalıştırın:
-----------------------------------

- name-sink
- name-processor
- name-source

RabbitMQ Dashboard (http://localhost:15672) üzerinden mesaj akışını izleyin veya name-sink uygulaması üzerinden konsolda çıkan sonuçları takip edin.

Proje Testi
===========

Uygulamaları çalıştırdığınızda, name-source tarafından üretilen isimlerin name-processor tarafından işlenerek zaman damgası ile birlikte name-sink üzerinden konsola yazıldığını gözlemleyebilirsiniz.

Bağımlılıklar
=============

- Spring Cloud Stream
- Spring Boot
- RabbitMQ

