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


void menu(void)//菜单 
{
	while(1)
	{
	int state=1;
	printf("学生信息管理系统：\n");
	printf("************************\n");
	printf("    *菜单\n");
	printf("    *1.输入*\n");
	printf("    *2.查找*\n");
	printf("    *3.插入*\n");
	printf("    *4.删除*\n");
	printf("    *5.输出*\n");
	printf("    *6.退出*\n");
	printf("************************\n");
	printf("请输入选项：");
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

void reacher(void)// 查找 
{
	NODE *p;
	int number;
	p=head->next;
	printf("请输入要查找的学号：\n");
	scanf("%d",&number);
	while(p!=NULL&&p->stu.number!=number)
	{
	      p=p->next;
	}
	if(p->stu.number==number)
	{
		printf("姓名：%s\n",p->stu.s);
		printf("学号：%d\n",p->stu.number);
		printf("成绩：%d\n",p->stu.num);
	}
	if(p==NULL)
	printf("不存在学号为%d的信息",number);
	
}
void insert(void)//插入 
{
	NODE *p,*s;s=head;
	int m;
	printf("请输入要插入的位置：\n");
	scanf("%d",&m);
	printf("请输入要插入的学号及信息：\n");
    p=(NODE *)malloc(sizeof(NODE));
    printf("姓名：");
	scanf("%s",p->stu.s);
	printf("学号：");
	scanf("%d",&(p->stu.number));
	printf("成绩：");
	scanf("%d",&(p->stu.num));
	for(int i=0;i<m;i++)
	s=s->next;
	p->next=s->next;
	s->next=p;
	
    
}
void delite(void)//删除 
{
	NODE *p,*s;
	int number;
	printf("请输入要删除的学号：\n");
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
		printf("不存在此学生的信息！！\n");
     	
}  


void creatlist(void)//创建链表 
{
	NODE *p,*e;
	head=(NODE *)malloc(sizeof(NODE));
	p=(NODE *)malloc(sizeof(NODE));
	head->next=p;
	printf("姓名：");
	scanf("%s",p->stu.s);
	printf("学号：");
	scanf("%d",&(p->stu.number));
	printf("成绩：");
	scanf("%d",&(p->stu.num));
	e=head;int i=0;
	while(i<1)
	{
		e=p;
		p=(NODE *)malloc(sizeof(NODE));
		printf("姓名：");
	    scanf("%s",p->stu.s);
    	printf("学号：");
     	scanf("%d",&(p->stu.number));
    	printf("成绩：");
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
    	printf("姓名：%s\n",p->stu.s);
    	printf("学号：%d\n",p->stu.number);
   		printf("成绩：%d\n",p->stu.num);
   		p=p->next;
    }
    
}
































