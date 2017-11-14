package nc.impl.am.failuredetect.validator;

import nc.bs.uif2.validation.ValidationFailure;
import nc.bs.uif2.validation.Validator;
import nc.vo.am.failuredetect.FailuredetectVO;

import org.apache.commons.lang.StringUtils;

/**
 * ������̨�ǿ�У��
 * @author cuikai
 *
 *
 */
public class FailuredetectNullValidator implements Validator { 

	public ValidationFailure validate(Object obj) {

		if (obj != null) {
			Object[] objs = null;
			if (obj.getClass().isArray()) {
				objs = (Object[]) obj;
			} else {
				objs = new Object[] { obj };
			}
			return batchValidate(objs);
		}
		return null;
	}

	/**
	 * �ǿ��ֶ�У��
	 * @param objs
	 * @return
	 */
	private ValidationFailure batchValidate(Object[] objs) {
		ValidationFailure validationFailure = null;
		if (objs.length > 0) {
			StringBuffer errorMessage = new StringBuffer();
			for (int i = 0; i < objs.length; i++) {
				FailuredetectVO vo = (FailuredetectVO) objs[i];

				if (StringUtils.isBlank(vo.getPk_group())) {
					errorMessage.append(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("failurebase_0","04501003-0031")/*@res "���Ų���Ϊ��."*/);
					break;
				}

				if (StringUtils.isBlank(vo.getPk_org())) {
					errorMessage.append(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("failurebase_0","04501003-0032")/*@res "��֯����Ϊ��."*/);
					break;
				}

				if (StringUtils.isBlank(vo.getCode())) {
					errorMessage.append(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("failurebase_0","04501003-0033")/*@res "���벻��Ϊ��."*/);
					break;
				}

				if (StringUtils.isBlank(vo.getName())) {
					errorMessage.append(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("failurebase_0","04501003-0034")/*@res "���Ʋ���Ϊ��."*/);
					break;
				}
			}

			if (errorMessage.length() > 0) {
				validationFailure = new ValidationFailure();
				validationFailure.setMessage(errorMessage.toString());
			}
		}
		return validationFailure;
	}

}