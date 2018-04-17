package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

//        for (int i = 0; i < 10; i++) {
//            Product pr = new Product();
//            pr.setName("Laptop Dell " + i);
//            pr.setDescription("Coll laptop with sensor screen " + i);
//            s.persist(pr);
//        }

//        List<Product> products = s.createQuery("FROM Product p", Product.class).getResultList();
////        System.out.println(products);
//
//        for (Product p : products) {
//            System.out.println("Product " + p + " category " + p.getCategory());
//        }

//        List<Category> categories = s.createQuery("FROM Category c").getResultList();
//        for (Category c : categories) {
//            System.out.println("=================== " + c.getName() + " ==========================");
//            System.out.println("products: " + c.getProducts().size());
//            for (Product p : c.getProducts()) {
//                System.out.println("product: " + p.getName());
//            }
//        }

        List<Product> products = s.createQuery("FROM Product p").getResultList();
        for(Product p: products){
            p.setCategory(products.get(0).getCategory());
        }

//        Category c = s.get(Category.class, 1l);
//        for (Product p : products) {
//            p.setCategory(c);
//        }

//        for (Product p : products) {
//            String name = p.getName();
//            p.setName(p.getDescription());
//            p.setDescription(name);
//            s.remove(p);
//        }

//        for (Product p : products) {
//            s.persist(p);
//        }

//        System.out.println(s.get(Product.class, 1l));
//        System.out.println(s.createQuery("FROM Product p WHERE p.id=1").getResultList());

        s.getTransaction().commit();
        s.close();

        sf.close();
    }
}
