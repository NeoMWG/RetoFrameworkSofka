# language: es

@FeatureName:validarFuncionamientoCarritoDeCompras
Característica: Validar Carrito de Compras

  Yo como cliente de la plataforma automationpractice.com deseo ingresar a la pagina y añadir productos
  al carrito de compras para su posterior adquisicion.

@ignore
@ScenarioName:pagoPorTransferenciaBancaria
Escenario: Pago de pedido por transferencia bancaria

  Dado que el cliente ingresa a la pagina inicial y realiza su registro exitosamente
  Cuando ingresa a la opcion T-Shirts elige la prenda y realiza su pedido por transferencia bancaria
  Entonces el usuario deberia poder visualizar un mensaje que indica que ha completado su orden


@ScenarioName:pagoConCheque
Escenario: Pago del pedido con cheque

  Dado que el cliente se encuentra registrado y avanza a la pagina principal del sitio web
  Cuando ingresa a la opcion T-Shirts elige la prenda y realiza su pedido mediante pago con cheque
  Entonces el usuario deberia poder visualizar un mensaje indicando que la orden ha sido completada


