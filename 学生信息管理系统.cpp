#include<stdio.h>
#include<malloc.h>
struct student 
{
	char s[20];
	int number;
	int num;
};
typedef struct node
{
	struct student stu;
	node *next; 
}NODE;
void menu(void);
void reacher(void);
void insert(void);
void delite(void);
void creatlist(void);
void list(void);
NODE *head;
int main(void)
{
	 menu();
	return 0;
}


void menu(void)//�˵� 
{
	while(1)
	{
	int state=1;
	printf("ѧ����Ϣ����ϵͳ��\n");
	printf("************************\n");
	printf("    *�˵�\n");
	printf("    *1.����*\n");
	printf("    *2.����*\n");
	printf("    *3.����*\n");
	printf("    *4.ɾ��*\n");
	printf("    *5.���*\n");
	printf("    *6.�˳�*\n");
	printf("************************\n");
	printf("������ѡ�");
	int a;
	scanf("%d",&a);
	switch(a)
	{
		case 1:creatlist();break;
		case 2:reacher();break;
		case 3: insert();break;
		case 4:delite();break;
		case 5:list();break;
		default:state=0;
	}
	if(state==0)
	break;
   }
   printf("Bye!");
    return; 
} 

void reacher(void)// ���� 
{
	NODE *p;
	int number;
	p=head->next;
	printf("������Ҫ���ҵ�ѧ�ţ�\n");
	scanf("%d",&number);
	while(p!=NULL&&p->stu.number!=number)
	{
	      p=p->next;
	}
	if(p->stu.number==number)
	{
		printf("������%s\n",p->stu.s);
		printf("ѧ�ţ�%d\n",p->stu.number);
		printf("�ɼ���%d\n",p->stu.num);
	}
	if(p==NULL)
	printf("������ѧ��Ϊ%d����Ϣ",number);
	
}
void insert(void)//���� 
{
	NODE *p,*s;s=head;
	int m;
	printf("������Ҫ�����λ�ã�\n");
	scanf("%d",&m);
	printf("������Ҫ�����ѧ�ż���Ϣ��\n");
    p=(NODE *)malloc(sizeof(NODE));
    printf("������");
	scanf("%s",p->stu.s);
	printf("ѧ�ţ�");
	scanf("%d",&(p->stu.number));
	printf("�ɼ���");
	scanf("%d",&(p->stu.num));
	for(int i=0;i<m;i++)
	s=s->next;
	p->next=s->next;
	s->next=p;
	
    
}
void delite(void)//ɾ�� 
{
	NODE *p,*s;
	int number;
	printf("������Ҫɾ����ѧ�ţ�\n");
	scanf("%d",&number);
	p=head->next;
	s=head;
	while(p->stu.number!=number&&p!=NULL)
	{
		s=p;
		p=p->next;
	}
		if(p->stu.number==number)
		{
			s->next=p->next;
			free(p);
		}
		else 
		printf("�����ڴ�ѧ������Ϣ����\n");
     	
}  


void creatlist(void)//�������� 
{
	NODE *p,*e;
	head=(NODE *)malloc(sizeof(NODE));
	p=(NODE *)malloc(sizeof(NODE));
	head->next=p;
	printf("������");
	scanf("%s",p->stu.s);
	printf("ѧ�ţ�");
	scanf("%d",&(p->stu.number));
	printf("�ɼ���");
	scanf("%d",&(p->stu.num));
	e=head;int i=0;
	while(i<1)
	{
		e=p;
		p=(NODE *)malloc(sizeof(NODE));
		printf("������");
	    scanf("%s",p->stu.s);
    	printf("ѧ�ţ�");
     	scanf("%d",&(p->stu.number));
    	printf("�ɼ���");
	    scanf("%d",&(p->stu.num));
	    i++;
		e->next=p;
	}
	e->next=NULL;
	
}
void list(void)
{
	NODE *p;
	p=head->next;
	while(p!=NULL)
    {
    	printf("������%s\n",p->stu.s);
    	printf("ѧ�ţ�%d\n",p->stu.number);
   		printf("�ɼ���%d\n",p->stu.num);
   		p=p->next;
    }
    
}
































