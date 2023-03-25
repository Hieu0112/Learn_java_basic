/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kethua;

/**
 *
 * @author trinh
 */
public abstract class Demo {
    private String name;
    public Demo(String name){
        this.name=name;
    }
    public abstract void lay();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
