package com.example.demo.dto;

public class DashboardDto {

    private Long totalStudents;
    private Long totalRooms;
    private Long occupaiedRooms;
    private Long availableRooms;

    // ✅ NEW: Alerts data
    private Long pendingPayments;
    private Long inactive30Days;
    private Long todayNewOrganizations;

    public Long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Long getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Long totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Long getOccupaiedRooms() {
        return occupaiedRooms;
    }

    public void setOccupaiedRooms(Long occupaiedRooms) {
        this.occupaiedRooms = occupaiedRooms;
    }

    public Long getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Long availableRooms) {
        this.availableRooms = availableRooms;
    }

    // ✅ New Getters & Setters
    public Long getPendingPayments() {
        return pendingPayments;
    }

    public void setPendingPayments(Long pendingPayments) {
        this.pendingPayments = pendingPayments;
    }

    public Long getInactive30Days() {
        return inactive30Days;
    }

    public void setInactive30Days(Long inactive30Days) {
        this.inactive30Days = inactive30Days;
    }

    public Long getTodayNewOrganizations() {
        return todayNewOrganizations;
    }

    public void setTodayNewOrganizations(Long todayNewOrganizations) {
        this.todayNewOrganizations = todayNewOrganizations;
    }
}

