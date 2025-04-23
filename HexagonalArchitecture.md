# Hexagonal Architecture
- Hexagonal Architecture is model designing software application around the domain layer to isolate it from external factors.
--Domain layer contains the bussiness logic of the application. domain layer is exposed using ports and adapters .
--Ports are the entry point to the application . Port determines interface which will allow actor to communicate with application
--Adapters initiate the intercation with application through ports using specific technology . In our project REST Controller which allows client to communicate
with appplication.


- Architecture layer :
```
    Adapter -> port -> ( application layer (Domain Layer) application layer ) -> port -> Adapter

                  Driving side                    |                Driven Side
    - Driving Adapter , port IN                      - Driven Adapter , port In
```

- Hexagonal Architecture has 2 sides . Driving Side & Driven Side

-- Driving Side : From Driving side Driving actors initiate the interaction, driving adapter could be a controller which takes user input and pass it to port In.
-- Driven Side : From Driven Side Driven actors are "kicked by behaviour" by application . Driven adapter could be database adapter that is called by application .

-- In project structure we have :
  - Adapter layer: adapter layer which contains all the spring related code
  - Application layer : it contains services and ports which are used to communicate which application.
    -- Ports : 2 Ports -> Port.In & Port.Out
    --e.g :
    --- Port.In : communicate with controller , expose use case methods to controller or adapter layer.
    --- Port.Out : communicate with database , expose the methods to the database adapters

  - Domain Layer : Core bussiness logic is implemented in this layer which leaves the User interface and Infracture layer outside .

- Advantage :
  Clean separation of concerns
  Highly testable and scalable
  Framework-agnostic core logic
  Great for real-time and modular systems

- Disadvantage :
  Slightly steeper learning curve
  More boilerplate (interfaces and adapters)
