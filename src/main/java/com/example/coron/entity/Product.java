package com.example.coron.entity;

import com.example.coron.dto.ProductDto;
import com.example.coron.dto.ProductInfo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@NamedNativeQuery(
        name = "getHotProductInfos",
        query =
                "select p.sku , p.name,p.price, i.url as image  from product p\n" +
                        "inner join image i on i.product_id = p.id \n" +
                        "group by p.id\n" +
                        "order by (select count(w.product_id) from wishlist w \n" +
                        "where w.product_id = p.id) desc",
        resultSetMapping = "listProductInfo"
)
@SqlResultSetMapping(
        name = "listProductInfo",
        classes = @ConstructorResult(
                targetClass = ProductInfo.class,
                columns = {
                        @ColumnResult(name = "sku", type = String.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "price", type = Integer.class),
                        @ColumnResult(name = "image", type = String.class)
                }
        )
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

@Table(name = "product",
        indexes = {@Index(name = "idx_product_sku",  columnList="sku", unique = true)})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sku", unique = true)
    private String sku;

    @Column(name = "name")
    private String name;


    @Column(name = "price")
    private Integer price;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id"))
    private Collection<Category> categories = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "product_materials",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "materials_id", referencedColumnName = "id"))
    private Collection<Material> materials = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id"))
    private Collection<Tag> tags = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Amount> amounts = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Image> images = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }


}