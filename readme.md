# DESCRIPCIÓN

Consigna entregada para el tp final del curso de programador JAVA dictado por la UTN-FRBA, bajo el programa de capacitación solicitado por la empresa Capgemini.

### CONSIGNA

A)  ***Contexto general***
- Nos han solicitado diseñar y desarrollar una plataforma de E-Commerce para la venta de productos de indumentaria semi-personalizados.

* * *

B) ***Relevamiento***
1.   Los gestores de la plataforma cargan los productos base que pueden ser personalizados y comercializados, como, por ejemplo, remeras, gorras, fundas para smartphones, zapatillas, entre otros. Para cada producto definen un nombre, un precio base, una descripción y un tiempo estimado de fabricación (ellos se encargan de fabricarlos). A cada producto base se le debe definir el área de personalización y por cada una de éstas, los tipos de personalizaciones que se podrán realizar. Por ejemplo: texto, imagen color, imagen blanco y negro, emoji, entre otros.<BR><BR>
2.   Los vendedores, que son clientes de los gestores (pagan por el uso de la plataforma), pueden personalizar cada uno de los productos que tienen a disposición, agregándole imágenes o frases para que sean estampadas en las áreas predefinidas.<BR><BR>
3.   A cada personalización le definen un nombre y un precio, el cual se suma al precio base del producto para formar el precio final de venta. Luego, pueden publicar dichos productos personalizados en su tienda (cada vendedor tiene su propia tienda dentro de la plataforma). Los vendedores deben poder pausar y cancelar sus publicaciones en cualquier momento.<BR><BR>
***TODO: Consultar si los gestores también deberían poder pausar los productos***
<BR><BR>
4.   Los compradores son considerados “esporádicos”, es decir, que no son frecuentes y no necesitan generarse una cuenta en el sistema para poder realizar una compra.<BR><BR>
5.   Cabe destacar que la plataforma debe contemplar el concepto de “carrito de compra”, es decir, que el comprador puede ir seleccionando todos los productos que quiera y luego comprarlos todos juntos.<BR><BR>
***TODO: Consultar si los carritos se manejarían en cookies?***
<BR><BR>
6.   Una vez que el cliente selecciona el o los productos personalizados, el sistema debe calcular el total de la compra, para que, posteriormente, el comprador los pague por alguno de los medios de pago admitidos. Cada vendedor define los Medios de Pago que acepta. Una vez aceptado el pago, se debe generar una Factura Electrónica a partir de un Servicio Externo.

* * *

C) ***Requerimientos***
1. Se pide implementarlo en una arquitectura Web, con 2 componentes
    - FrontEnd: proyecto Front usado el FW Angular2
    - BackEnd: proyecto API REST con persistencia - usando Java-Spring <BR><BR>

2. Se deben implementar las pantallas del comprador:
    - Login
    - Proceso de compra
    - Listado de productos - Buscador
    - Agregar al carrito
    - Confirmar Compra
    - Mostrar resultado de Compra
    - Ver el listado de las compras realizadas
  *NOTA:* Se deben desarrollar todos los métodos en la API REST para darle soporte a esto<BR><BR>


3. SOLO POR API
    - ABM de Productos Base
    - ABM de productos Personalizados<BR><BR>

4. NO HACE FALTA
Hacer pantalla de registrar usuario
Hacer las pantallas de lo que se pide en la API<BR><BR>

---

##Consideraciones para la entrega

- Se debe exponer el trabajo realizado en 5 minutos!. Así que la presentación debe estar guionada y practicada. Por ello se deben tener datos ya pre-cargados, como productos base, personalizados, características, usuarios y todo lo que considere necesario.<BR><BR>
- Para probar las API tener los requests/JSON ya armados en el Postman.<BR><BR>
- Para las pantallas lo mismo, tienen que tener pensado como mostrar el circuito de compra.
<BR><BR>

---

<BR><BR>

#### CLASES UML:

![Base UML Class Diagram](./documents/model.uml.drawio.svg#center "CLASES UML" )

