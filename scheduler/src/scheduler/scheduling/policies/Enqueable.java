/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

/**
 *
 * @author Johan Chan
 */
public interface Enqueable {
    
    public void add(SimpleProcess p);
    
    public void remove();
    
    public SimpleProcess next();
}
