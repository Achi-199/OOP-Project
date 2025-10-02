# 🚀 Interstellar Cruiser - Space Exploration Simulation

A Java-based space exploration simulation system that models an advanced spacecraft capable of navigating between planetary destinations with different mission strategies.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Navigation Modes](#navigation-modes)
- [Testing](#testing)
- [Project Structure](#project-structure)
- [Documentation](#documentation)
- [Author](#author)

## 🌌 Overview

The Interstellar Cruiser is a sophisticated space exploration system designed for the **Orion mission**. It simulates a spacecraft that can autonomously navigate between planetary destinations, manage fuel consumption, and execute complex mission strategies based on different exploration priorities.

This project demonstrates advanced Object-Oriented Programming concepts including:
- **Encapsulation** with well-defined component responsibilities
- **Abstraction** through strategic navigation interfaces
- **Composition** for complex system integration
- **Enum-based state management** for navigation modes

## ✨ Features

- **🎯 Multi-Mode Navigation**: Choose between Standard, Efficient, and Exploration strategies
- **⛽ Dynamic Fuel Management**: Intelligent fuel consumption and capacity monitoring
- **🚀 Advanced Propulsion System**: Modular thruster core with configurable parameters
- **🤖 Autonomous Pilot**: AI-driven decision making for route optimization
- **📊 Mission Analytics**: Real-time tracking of exploration progress and efficiency
- **📁 Flexible Target Loading**: Import planetary destinations from external data files
- **🧪 Comprehensive Testing**: Full unit test coverage for all major components

## 🏗️ Architecture

The system follows a modular architecture with clear separation of concerns:

### Core Components

| Component | Responsibility |
|-----------|----------------|
| **InterstellarCruiser** | Central mission controller and component orchestrator |
| **RouteManager** | Navigation logic and destination management |
| **PropellantChamber** | Fuel storage and consumption tracking |
| **ThrusterCore** | Propulsion system control |
| **AstroPilot** | Autonomous navigation decision making |
| **PlanetStop** | Individual destination modeling |
| **SpaceWaypoint** | Navigation point abstraction |

### Navigation System

```
NavigationMode (Enum)
├── STANDARD     → Balanced approach
├── EFFICIENT    → Fuel-optimized routes
└── EXPLORATION  → Science-value maximization
```

## 🚀 Getting Started

### Prerequisites

- **Java 8** or higher
- **JUnit 4** for running tests
- **Apache Ant** or **NetBeans IDE** for building

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Achi-199/OOP-Project.git
   cd OOP-Project
   ```

2. **Compile the project**:
   ```bash
   # Using javac directly
   javac -cp . src/*.java
   
   # Or using NetBeans/Ant
   ant compile
   ```

3. **Run the simulation**:
   ```bash
   java -cp . Main
   ```

## 💻 Usage

### Basic Mission Setup

```java
// Create a new interstellar cruiser
InterstellarCruiser cruiser = new InterstellarCruiser();

// Set navigation strategy
cruiser.setNavigationMode(NavigationMode.EXPLORATION);

// Load planetary destinations
cruiser.importTargets("destinations.txt");

// Begin the mission
cruiser.beginMission();
```

### Destination File Format

Create a `destinations.txt` file with the following format:
```
PlanetName Distance FuelRate ScientificValue
Jupiter 1000 8 60
Saturn 500 5 40
Neptune 200 10 90
Mars 4000 15 100
```

**Format specifications**:
- **PlanetName**: String identifier for the destination
- **Distance**: Integer distance in space units
- **FuelRate**: Integer fuel consumption per unit distance
- **ScientificValue**: Integer scientific research value (0-100)

## 🧭 Navigation Modes

### STANDARD Mode
- **Purpose**: Balanced exploration approach
- **Strategy**: Considers both fuel efficiency and scientific value
- **Best for**: General purpose missions with moderate constraints

### EFFICIENT Mode  
- **Purpose**: Fuel-optimized navigation
- **Strategy**: Prioritizes destinations with lowest fuel consumption
- **Best for**: Long-duration missions with limited fuel supplies

### EXPLORATION Mode
- **Purpose**: Maximum scientific discovery
- **Strategy**: Targets destinations with highest scientific value
- **Best for**: Research-focused missions with adequate fuel reserves

## 🧪 Testing

The project includes comprehensive unit tests for all major components:

### Running Tests

```bash
# Compile tests
javac -cp .:junit-4.12.jar test/*.java

# Run specific test
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore InterstellarCruiserTest

# Run all tests
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore InterstellarCruiserTest PlanetStopTest RouteManagerTest
```

### Test Coverage

| Component | Test File | Coverage |
|-----------|-----------|----------|
| InterstellarCruiser | `InterstellarCruiserTest.java` | Core functionality, fuel management, navigation |
| PlanetStop | `PlanetStopTest.java` | Destination properties, scientific calculations |
| RouteManager | `RouteManagerTest.java` | Route optimization, mode switching |

## 📁 Project Structure

```
OOP-Project/
├── src/                          # Source code
│   ├── Main.java                 # Application entry point
│   ├── InterstellarCruiser.java  # Main controller
│   ├── RouteManager.java         # Navigation management
│   ├── PropellantChamber.java    # Fuel system
│   ├── ThrusterCore.java         # Propulsion system
│   ├── AstroPilot.java          # Autonomous pilot
│   ├── PlanetStop.java          # Destination model
│   ├── SpaceWaypoint.java       # Navigation interface
│   └── NavigationMode.java      # Navigation strategies
├── test/                         # Unit tests
│   ├── InterstellarCruiserTest.java
│   ├── PlanetStopTest.java
│   └── RouteManagerTest.java
├── destinations.txt              # Sample destination data
├── Archil Nadaraia Documentation.pdf  # Detailed project documentation
└── README.md                     # This file
```

## 📚 Documentation

For detailed technical documentation, algorithm explanations, and design decisions, please refer to:
- **[Archil Nadaraia Documentation.pdf](./Archil%20Nadaraia%20Documentation.pdf)** - Comprehensive project documentation

## 🎓 Academic Context

This project was developed as part of the **Object-Oriented Programming (OOP)** course for the **4th Semester** at **ELTE (Eötvös Loránd University)**.

### Learning Objectives Demonstrated

- ✅ **Class Design**: Well-structured classes with clear responsibilities
- ✅ **Inheritance & Interfaces**: Proper use of OOP inheritance patterns
- ✅ **Encapsulation**: Data hiding and controlled access methods
- ✅ **Polymorphism**: Strategy pattern implementation via NavigationMode
- ✅ **Testing**: Comprehensive unit test coverage
- ✅ **Documentation**: Clear code documentation and user guides

## 👨‍💻 Author

**Archil Nadaraia** ([@Achi-199](https://github.com/Achi-199))
- 🎓 Student at ELTE University
- 💼 Course: Object-Oriented Programming (4th Semester)

---

### 🌟 Project Highlights

- **Modular Design**: Clean separation of concerns across components
- **Extensible Architecture**: Easy to add new navigation modes or spacecraft components  
- **Real-world Modeling**: Simulates actual space mission planning considerations
- **Professional Testing**: Industry-standard unit testing practices
- **Comprehensive Documentation**: Both code-level and user-facing documentation

---

*🚀 Ready for interstellar exploration? Clone the repository and begin your space mission today!*