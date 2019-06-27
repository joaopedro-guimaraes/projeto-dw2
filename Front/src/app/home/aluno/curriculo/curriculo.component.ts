import { Component, OnInit } from '@angular/core';
import { AlunoService } from 'src/app/core/services';
import { CadastroModel, CurriculoModel, Academic, Professional } from 'src/app/core/models';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-curriculo',
  templateUrl: './curriculo.component.html',
  styleUrls: ['./curriculo.component.scss']
})
export class CurriculoComponent implements OnInit {

  dados: CadastroModel;
  view = false;

  flagCurriculo = false;
  flagProfessional = false;

  curriculoForm = new FormGroup({
    'institution': new FormControl(null),
    'course': new FormControl(null),
    'level': new FormControl(null),
    'situation': new FormControl(null),
  });

  professionalForm = new FormGroup({
    'company': new FormControl(null),
    'function': new FormControl(null),
    'dateAdmission': new FormControl(null),
    'dateDemission': new FormControl(null),
    'executeTasks': new FormControl(null),
  });

  curriculum: CurriculoModel = {
    idStudent: 0,
    curriculum: {
      identification: 'CV',
      academicFormationList: [],
      professionalExperienceList: []
    }
  };

  constructor(
    private readonly alunoService: AlunoService,
  ) { }

  ngOnInit() {
    let user = JSON.parse(localStorage.getItem('user'));
    console.log(user.idUser)
    this.alunoService.getAluno(user.idUser)
      .subscribe(
        res => {
          this.dados = res[0];
        },
        () => console.error(),
        () => this.view = true,
      );
    
      this.curriculum.idStudent = user.idUser;
  }

  curriculo() {
    this.flagCurriculo = this.flagCurriculo ? false : true;
  }

  professional() {
    this.flagProfessional = this.flagProfessional ? false : true;
  }

  onSubmit() {

    let academic: Academic = {
      institution: this.curriculoForm.value.institution,
      course: this.curriculoForm.value.course,
      level: this.curriculoForm.value.level,
      situation: this.curriculoForm.value.situation,
    } 

    this.curriculum.curriculum.academicFormationList.push(academic);
    this.curriculoForm.reset();
    this.flagCurriculo = false;
  }

  onSubmitProfessional() {

    let professional: Professional = {
      company: this.professionalForm.value.company,
      function: this.professionalForm.value.function,
      dateAdmission: this.professionalForm.value.dateAdmission,
      dateDemission: this.professionalForm.value.dateDemission,
      executeTasks: this.professionalForm.value.executeTasks,
    } 

    this.curriculum.curriculum.professionalExperienceList.push(professional);
    this.professionalForm.reset();
    this.flagProfessional = false;
  }

  salvarTudo() {
    this.alunoService.curriculo(this.curriculum)
    .subscribe(res => console.log(res));
  }


}
