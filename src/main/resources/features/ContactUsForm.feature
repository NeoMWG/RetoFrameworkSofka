# language: es

  @FeatureName:envioInformacionFormularioContactenos
  Característica: Envio de informacion a traves de formulario de contacto

    Como usuario de la plataforma automationpractice.com
    deseo enviar informacion al administrador del sitio
    con el fin de dar feedback de algunos productos

  @ScenarioName:envioCorrectoInformacionFormularioContactenos
  Escenario: Envio correcto de informacion de contacto

      Dado que el cliente se encuentra registrado en la pagina y se encuentra en pagina de inicio
      Cuando el cliente desea consultar algo al administrador de la pagina y da click en Contactenos
      Y llena los campos descritos en la seccion en su totalidad
      Entonces el usuario deberia recibir un mensaje indicando que se ha enviado el mensaje correctamente.


  @ScenarioName:envioIncorrectoInformacionFormularioContactenos
  Escenario: Envio incorrecto de informacion de contacto

    Dado que el cliente ya se se encuentra registrado en la plataforma y se halla en la pagina de inicio
    Cuando el cliente requiere consultar o solicitar algo al administrador de la pagina y da click en Contactenos
    Y llena los campos descritos en la seccion sin incluir informacion en el mensaje
    Entonces el usuario deberia poder visualizar un mensaje indicando que el mensaje no puede estar en blanco
