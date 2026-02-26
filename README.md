# Distance & Level System v2 — Java Unit Testing Project 🧪

A refactored Java project demonstrating advanced software testing principles through Black-Box and White-Box testing. This version introduces a `UnitConverter` **interface** instead of a concrete class, enabling true mock-based dependency injection testing with Mockito, and uses a `HashSet` in `LevelSystem` for uniqueness checking.

---

> ⚠️ **This repository contains the source code and tests for a software testing project.** The focus is on test design methodology — specifically dependency injection via interfaces, mock testing, and coverage-driven white-box design.

---

## 🔄 Key Differences from v1

| Feature | Version 1 | Version 2 (This Repo) |
|---|---|---|
| `UnitConverter` | Concrete class | **Interface** |
| Method name | `metersToCentimetersCalculate()` | `metersToCentimeters()` |
| `LevelSystem` | Array-based uniqueness check | **HashSet** for concept tracking |
| Mock testing | Mocking a class | Mocking an **interface** (cleaner) |
| Dependency injection | Partial | Fully interface-driven |

---

## 🚀 Features

- **DistanceSystem** — manages distance (1–10) and degrees with input validation and default fallback
- **LevelSystem** — maps levels 1–6 to programming concepts with `HashSet` and custom exception handling
- **UnitConverter (Interface)** — defines contract for unit conversion, fully mockable in tests
- **InvalidLevelException** — custom `RuntimeException` for out-of-range level inputs
- **Interface-based Dependency Injection** — `UnitConverter` interface injected into `DistanceSystem` for clean, isolated testing

---

## 🛠️ Tech Stack

- Java
- JUnit (Unit Testing)
- Mockito (Interface mocking for dependency injection tests)
- Black-Box Testing
- White-Box Testing

---

## 📂 Project Structure

```
├── src/
│   ├── main/java/nz/ac/auckland/se283/
│   │   ├── DistanceSystem.java               # Distance/degrees manager with validation
│   │   ├── LevelSystem.java                  # Level-to-concept mapper with HashSet
│   │   ├── UnitConverter.java                # Interface defining metersToCentimeters()
│   │   └── InvalidLevelException.java        # Custom exception for invalid levels
│   └── test/java/nz/ac/auckland/se283/
│       ├── DistanceSystemBlackBoxTest.java   # Black-box tests for DistanceSystem
│       ├── DistanceSystemWhiteBoxTest.java   # White-box tests for DistanceSystem
│       ├── LevelSystemBlackBoxTest.java      # Black-box tests for LevelSystem
│       └── LevelSystemWhiteBoxTest.java      # White-box tests for LevelSystem
└── README.md
```

---

## 🔬 Testing Methodology

### Black-Box Testing
Tests written purely based on **expected input/output behaviour** without knowledge of internal implementation. Focuses on:
- **Equivalence Partitioning** — valid and invalid input ranges
- **Boundary Value Analysis** — testing at and around boundary values (e.g. distance = 1, 10, 0, 11)
- **Exception Testing** — verifying `InvalidLevelException` is thrown for levels outside 1–6

### White-Box Testing
Tests written with **full knowledge of internal code paths**. Focuses on:
- **Branch Coverage** — ensuring every `if/else` branch is exercised
- **Path Coverage** — covering all logical paths through nested loops in `checkIfDifferent()`
- **Interface Mock Testing** — mocking the `UnitConverter` interface with Mockito to fully isolate `DistanceSystem` logic from conversion behaviour

---

## 📋 Classes Under Test

### DistanceSystem

| Constructor | Behaviour |
|---|---|
| `DistanceSystem()` | Default: distance = 5, degrees = 0 |
| `DistanceSystem(int distance, int degrees)` | Validates distance 1–10, defaults to 5 if invalid |
| `DistanceSystem(UnitConverter uc)` | Interface-based dependency injection constructor |
| `DistanceSystem(int, int, UnitConverter)` | Full constructor with validation + interface injection |

| Method | Description |
|---|---|
| `getDistance()` | Returns current distance value |
| `getDegrees()` | Returns current degrees value |
| `metersToCentimeters(double)` | Delegates to injected UnitConverter interface |

**Boundary Values to Test:**

| Input | Expected Distance |
|---|---|
| distance = 0 | 5 (default) |
| distance = 1 | 1 (valid) |
| distance = 5 | 5 (valid) |
| distance = 10 | 10 (valid) |
| distance = 11 | 5 (default) |

---

### LevelSystem

| Method | Description |
|---|---|
| `getConceptForLevel(int level)` | Returns concept string for levels 1–6, throws `InvalidLevelException` otherwise |
| `getAllConcepts()` | Returns all 6 concepts as a comma-separated string |
| `checkIfDifferent()` | Returns true if all 6 concepts are unique via nested loop comparison |

**Level Mappings:**

| Level | Concept |
|---|---|
| 1 | Variables |
| 2 | Operators |
| 3 | Conditional_Statements |
| 4 | Loops |
| 5 | Methods |
| 6 | Arrays_and_ArrayLists |

**Boundary Values to Test:**

| Input | Expected Behaviour |
|---|---|
| level = 0 | Throws `InvalidLevelException` |
| level = 1 | Returns "Variables" |
| level = 3 | Returns "Conditional_Statements" |
| level = 6 | Returns "Arrays_and_ArrayLists" |
| level = 7 | Throws `InvalidLevelException` |

---

### UnitConverter (Interface)

```java
public interface UnitConverter {
    public abstract double metersToCentimeters(double meters);
}
```

Implemented or mocked in tests — never instantiated directly. This allows Mockito to stub return values without any real conversion logic running.

**Example mock usage:**
```java
UnitConverter mockConverter = Mockito.mock(UnitConverter.class);
Mockito.when(mockConverter.metersToCentimeters(1.0)).thenReturn(100.0);
DistanceSystem ds = new DistanceSystem(5, 0, mockConverter);
```

---

## 🏃 How to Run

1. Clone the repository:
```bash
git clone https://github.com/YOURUSERNAME/distance-level-system-v2.git
```

2. Run all tests:
```bash
./mvnw test
```

3. Run a specific test class:
```bash
./mvnw test -Dtest=DistanceSystemBlackBoxTest
./mvnw test -Dtest=LevelSystemWhiteBoxTest
```

---

## 🎓 What I Learned

- Designing interface-based dependency injection to enable clean, isolated unit tests
- Applying Mockito to mock interfaces and stub method return values for controlled testing
- Differentiating black-box vs white-box testing strategies and when to use each
- Achieving branch and path coverage through systematic white-box test design
- Writing boundary value and equivalence partition tests for input validation logic
- Using `HashSet` for efficient uniqueness checking in place of nested array comparisons

---

## 📬 Contact

**Tanush Panuganti**
- GitHub: [Goldengamer255](https://github.com/Goldengamer255)
- LinkedIn: [tanush-panuganti](https://linkedin.com/in/tanush-panuganti)
- Email: tanush.panu@gmail.com
