package com.quiz2pbo_1972008.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "anggota", schema = "kuis2pbo2", catalog = "")
public class AnggotaEntity {
    private int id;
    private String nama;
    private String alamat;
    private String notelpon;
    private Date tglLahir;
    private Date tglMasuk;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "alamat")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "notelpon")
    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }

    @Basic
    @Column(name = "tglLahir")
    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Basic
    @Column(name = "tglMasuk")
    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnggotaEntity that = (AnggotaEntity) o;
        return id == that.id && Objects.equals(nama, that.nama) && Objects.equals(alamat, that.alamat) && Objects.equals(notelpon, that.notelpon) && Objects.equals(tglLahir, that.tglLahir) && Objects.equals(tglMasuk, that.tglMasuk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat, notelpon, tglLahir, tglMasuk);
    }
}
