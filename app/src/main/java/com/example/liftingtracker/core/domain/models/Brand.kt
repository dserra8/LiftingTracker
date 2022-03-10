package com.example.liftingtracker.core.domain.models

enum class Brand {
    NOBRAND,
    LifeFitness {
        override fun toString(): String {
            return "Life Fitness"
        }
    },
    Precor,
    HammerStrength {
        override fun toString(): String {
            return "Hammer Strength"
        }
    },
    StarTrac {
        override fun toString(): String {
            return "Star Trac"
        }
    },
    YanreFitness {
        override fun toString(): String {
            return "Yanre Fitness"
        }
    },
    Cybex,
    IronCompany {
        override fun toString(): String {
            return "Iron Company"
        }
    },
    TrueFitness {
        override fun toString(): String {
            return "True Fitness"
        }
    },
    NordicTrack,
    ProForm,
    Matrix
}