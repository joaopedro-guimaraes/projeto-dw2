export interface CadastroModel {
    userStudent: {
        idUser: number;
    },
    register: string;
    name: string;
    address: string;
    number: number,
    city: string;
    neighborhood: string;
    state: string;
    cep: number;
    telephone: number;
    course: string;
    dataIngresso: string;
}

export interface CurriculoModel {
    idStudent: number,
    curriculum: {
        identification: string,
        academicFormationList: Academic[],
        professionalExperienceList: Professional[]
    }
}

export interface Academic {
    institution: string,
    course: string,
    level: string,
    situation: string
}

export interface Professional {
    company: string,
    function: string,
    dateAdmission: string,
    dateDemission: string,
    executeTasks: string
}
