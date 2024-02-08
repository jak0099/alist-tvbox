package cn.har01d.alist_tvbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@TableGenerator(name = "tableGenerator", table = "id_generator", pkColumnName = "entity_name", valueColumnName = "next_id", allocationSize = 1)
public class TmdbMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGenerator")
    private Integer id;
    @Column(unique = true)
    private String path;
    private String name;
    private String type = "movie";
    @Column(name = "`year`")
    private Integer year;
    private Integer score;
    private Integer tmId;
    @ManyToOne
    private Tmdb tmdb;
}