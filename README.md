# Spring Boot

**Un framework web basado en MVC toma ventajas de los siguientes principios**

- Modelo, Vista y Controlador
- Inyección de Dependencia
- Orientado al uso de Interfaces
- Uso de clases  Plain Old Java Object (POJO)

## Cómo funciona Spring
- El Front Controller Dispatcher recibe una solicitud HTTP del navegador

- Luego aplica un controlador basado en la URL (Handler mapping) y asigna el request al Controlador

- El controlador se relaciona con componentes de la lógica de negorio y envía datos a la vista usando el objeto Model

- El controlador retorna/asigna el nombre de la vista lógica a mostrar

- Se selecciona un ViewResolver, el cual aplica un determinado tipo de vista (HTML, PDF, Excel, etc.)

- Finalmente la vista es mostrada al cliente usando los datos del objeto Model

## Clara separación de funciones

Controlador, validadores, objeto form, DispatcherServlet, Handler mapping, view resolver, etc.

- Llevan a cabo una tarea específica y pueden ser reemplazables sin afectar a los demás

## ¿Qué hace un controlador?

- Los Controladores proporcionan acceso a la lógica de negocio. Delega la lógica de negocio a un conjunto de componentes de servicios.

- Los controladores reciben parámetros del usuario (input) y los convierte en un objeto del modelo, poblando en sus atributos los datos enviados, como resultado de la lógica de negocio.

# Introducción al contenedor y la inyección de dependencias

## ¿Qué es la inyección de Dependencia?

Es suministrar a un objeto una referencia de otro(s) objetos(s) que necesite según la relación.

- Resuelve el problema de reutilización y modularidad entre componentes

**Objeto B** `->` (B es inyectado en A) **Objeto A** *Objeto B*

## Cómo funciona

El contenedor se encarga de gestionar las instancias y dependencias de componentes mediante la relación e inyección de objetos

- En contra-popsición de la creación explícita (operador new) de objetos

- Esto permite un bajo acoplamiento entre los objetos

- Tiene que plasmarse mediante la anotación @Autowired

## Anotación @Autowired

Especifica que se inyectará un objeto de spring (bean o componente) es un atributo de otro objeto

- Es decir para inyectar un bean de spring en el componente actual

- Por defecto, la inyección falla si no encuentra candidatos disponibles

Anotación @Autowired

## Lugares donde se puede utilizar @Autowired

- Atributos
- Métodos setter
- Constructor

## Anotación @Component y sus derivados

## @Component es un estereotipo genérico para cualquier componente manejado por Spring

# @Repository para persistencia, componentes que acceden a los datos (DAO's)
- @Service para servicios de lógica de negocio
- @Controller para los controladores MVC

## Componentes o beans

**El término "bean" se utiliza para referirse a cualquier componente manejado por Spring**

Los beans deben ser anotado con la anotación **@Component** o sus derivados
Debe tener un constructor vacío por defecto, sin argumentos
- Cualquier beans anotado con @Component (o derivados) bajo el package serán instanciados y manejados por el contenedor DI de Spring (Auto-Scanning)
