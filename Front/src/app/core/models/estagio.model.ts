export interface EstagioModel {
    idCompany: number;
    internship: {
        description: string;
        requiredRequirements: string;
        desirableRequirements: string;
    }
}