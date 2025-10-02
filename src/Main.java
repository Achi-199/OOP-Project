/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
public class Main {
    public static void main(String[] args) {
        InterstellarCruiser cruiser = new InterstellarCruiser();
        cruiser.setNavigationMode(NavigationMode.EXPLORATION); // Choose mode: STANDARD, EFFICIENT, or EXPLORATION
        cruiser.importTargets("destinations.txt");
        cruiser.beginMission();
    }
}
