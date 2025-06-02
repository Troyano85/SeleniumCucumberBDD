Feature:  Funcionalidad de la Tienda

  Background:
      Given Navego a la pagina de compras

    @regression
    Scenario: Verificar la interfaz de usuario de la página de compras
      Then Verifico la ui de la pagina de compras

    Scenario: Agregar todos los artículos al carrito
      When hago click en el botón Añadir  para todos los artículos
      Then Verifico que el checkout salga el numero 6
    @regression
    Scenario: Ordenar los artículos por nombre descendente Z->A
      When Cuando selecciono Z A del desplegable de ordenamiento
      Then Verifico que el primer nombre sea "Test.allTheThings() T-Shirt (Red)" y el último sea "Sauce Labs Backpack"
    @regression
    Scenario: Ordenar los artículos por precio de menor a mayor
      When Cuando selecciono Precio bajo a alto del desplegable de ordenamiento
      Then verifico que el primer articulo tenga el precio de"$7.99" y el ultimo articulo sea "$49.99"