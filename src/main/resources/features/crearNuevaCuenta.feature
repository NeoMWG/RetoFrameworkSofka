# language: es
  @FeatureName:crearNuevaCuenta
  Característica: Crear nueva cuenta
    Como cliente en línea
    necesito crear una cuenta
    para poder realizar compras en línea.

  @ScenarioName:CrearUnaCuenta
  Escenario: Crear una cuenta.
    Dado que el cliente esta en la página de inicio
    Cuando el cliente registra sus datos para una cuenta en línea de forma exitosa
    Entonces como resultado el usuario quedará logueado dentro de su respectiva sesión per se.
