# Dinosaur Predator-Prey Simulation

**Developed by:**  
Krishna Prasanna Kumar (K21004839)  
Shozab Anwar Siddique (K21054573)  

## Project Overview

The **Dinosaur Predator-Prey Simulation** is an engaging model that simulates the interactions between various dinosaur species and their environment. The simulation explores the dynamics of a food chain involving dinosaurs as predators and plants as producers, incorporating complex behaviors such as breeding, disease, and environmental effects.

## Species in the Simulation

1. **Dinosaurs:**
   - **Primary Dinosaurs (Herbivores):**  
     - Velociraptor
     - Triceratops
   - **Secondary Dinosaurs (Carnivores):**  
     - Spinosaurus
   - **Tertiary Dinosaurs (Apex Predators):**  
     - Tyrannosaurus
     - Brachiosaurus  

2. **Plants:**  
   - Represent the primary producers in the simulation, providing energy for the primary dinosaurs.

## Key Features

- **Dinosaur Classes and Behavior:**
  - The `Dinosaur` abstract class is divided into three categories: primary, secondary, and tertiary, each with specific species.
  - Dinosaurs are assigned unique speeds, impacting their movement, feeding, and breeding behavior.
  - Breeding occurs only between male and female dinosaurs of the same species that are adjacent to each other.

- **Plant Growth:**
  - Plants generate energy and grow based on environmental factors such as sunlight and rain.
  - When eaten by primary dinosaurs, plants remain in the simulation, allowing for regrowth.

- **Disease Mechanics:**
  - Dinosaurs and plants can carry diseases that may be transmitted upon contact.
  - Dinosaurs can recover, die, or continue living with the disease, impacting their behavior and interactions.

- **Day/Night Cycle:**
  - The simulation keeps track of time, affecting the activity levels of different species.
  - Some dinosaurs sleep at night, while others hunt, creating a dynamic environment.

- **Speed and Evolution:**
  - Each dinosaur is assigned a speed, influencing their activities in real-time.
  - Offspring have a chance to inherit improved speed traits, simulating evolutionary processes.

## Simulation Mechanics

- **Feeding and Competition:**
  - Primary dinosaurs compete for plant resources, while secondary and tertiary dinosaurs compete for prey.
  - The simulation employs an inheritance structure to manage species interactions and disease spread efficiently.

- **Weather Effects:**
  - Weather impacts the behavior of species and plant growth. Different weather conditions affect the speed of dinosaurs and the growth rate of plants.

- **Sleep and Idle Behavior:**
  - Each species has designated sleeping times, affecting their availability for movement and feeding.

## Challenge Tasks Implemented

1. **Simulating Plant Growth:**  
   Plants grow and can be affected by weather changes.

2. **Simulating Weather:**  
   Weather influences the behavior of organisms and environmental conditions.

3. **Disease Simulation:**  
   Infections spread through contact, affecting the health and behavior of dinosaurs.

4. **Speed and Evolutionary Traits:**  
   Speed is linked to real-time dynamics, with offspring having chances to evolve.

## Usage

1. Clone or download the repository.
2. Ensure you have the necessary Java environment set up.
3. Run the simulation to observe the interactions between species in real-time.

## Conclusion

The Dinosaur Predator-Prey Simulation provides insights into ecological dynamics, emphasizing the complexities of predator-prey relationships, competition, and environmental influences. This project aims to foster a deeper understanding of ecological systems and evolutionary principles.

## Authors

- Krishna Prasanna Kumar (K21004839)
- Shozab Anwar Siddique (K21054573)
