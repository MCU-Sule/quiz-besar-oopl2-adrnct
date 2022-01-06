package com.quiz2pbo_1972008.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buku", schema = "kuis2pbo2", catalog = "")
public class BukuEntity {
    private int id;
    private String judul;
    private String penerbit;
    private String pengarang;
    private String tahunTerbit;
    private String jenisBuku;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "judul")
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Basic
    @Column(name = "penerbit")
    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Basic
    @Column(name = "pengarang")
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    @Basic
    @Column(name = "tahunTerbit")
    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    @Basic
    @Column(name = "jenisBuku")
    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukuEntity that = (BukuEntity) o;
        return id == that.id && Objects.equals(judul, that.judul) && Objects.equals(penerbit, that.penerbit) && Objects.equals(pengarang, that.pengarang) && Objects.equals(tahunTerbit, that.tahunTerbit) && Objects.equals(jenisBuku, that.jenisBuku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, judul, penerbit, pengarang, tahunTerbit, jenisBuku);
    }
}
