from django.views import generic
from .models import Question


class IndexView(generic.ListView):
    model = Question
    template_name = 'polls/index.html'

    def get_queryset(self, *args, **kwargs):
        """Return the last five published questions."""
        question_list = Question.objects.all().order_by('-pub_date')[:5]
        context = super(IndexView, self).get_queryset(*args, **kwargs)
        context['latest_question_list'] = question_list
        return context
