package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Kanstantsin on 17.04.2018.
 */
public class MainCat {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();


//        for(int i = 1; i < 11; i++) {
//            Category category = new Category();
//            category.setName("Computer" + i);
//            category.setDescription("sgkjdlghskadj");
//            s.persist(category);
//        }

        List<Category> categories = s.createQuery("FROM Category c", Category.class).getResultList();
        System.out.println(categories);
        for(Category c: categories){
            if(c.getName().contains("1")) {
                System.out.print("remove");
                s.remove(c);
            }else{
                System.out.print("change name");
                c.setName(c.getName() + "new");
            }
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
